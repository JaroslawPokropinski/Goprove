package Prove;

import Expressions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoopStatement implements Statement {
    private Expression condition;
    private List<Statement> body;
    private Expression invariant, variant;
    private int line;
    private List<OperandName> var = null;
    private List<Expression> postAssertion = new ArrayList<>();

    private Expression calculatedCondition = null;
    private OperandName loopVar;

    public LoopStatement(int line, Expression condition, List<Statement> body, Expression invariant, Expression variant) {
        if (condition == null || body == null || invariant == null || variant == null) {
            throw new NullPointerException("At line: " + line);
        }
        for (Statement st : body) {
            if (st == null) {
                throw new NullPointerException("At line: " + line);
            }
        }
        this.line = line;
        this.condition = condition;
        this.body = body;
        this.invariant = invariant;
        this.variant = variant;

        loopVar = new OperandName(String.format("loopVar'%d", loopVarCount));
        loopVarCount++;
    }

    @Override
    public List<OperandName> getVariables() {
        if (var == null) {
            var = new ArrayList<>();
            for (Statement statement : body) {
                statement
                        .getVariables()
                        .forEach((v) -> {
                            if (!var.contains(v)) {
                                var.add(v);
                            }
                        });
            }
        }
        return var;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        // TODO: add invariant to forward assertion
        for (Iterator<Expression> iterator = prev.iterator(); iterator.hasNext(); ) {
            Expression next = iterator.next();
            // if next contains any of variables then remove it
            for (OperandName v : getVariables()) {
                if (next.contains(v)) {
                    iterator.remove();
                    break;
                }
            }
        }

        // loopVar global prev add loopVar == variant and loop
        prev.add(new BinaryExpression(loopVar, variant, "=="));

        for (Statement block : body) {
            prev = block.getForwardAssertion(prev);
        }
        postAssertion.addAll(prev);
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (invariant != null) {
            stringBuilder.append("inv ");
            stringBuilder.append(invariant);
            stringBuilder.append(" \n");
        }
        if (invariant != null) {
            stringBuilder.append("var ");
            stringBuilder.append(variant);
            stringBuilder.append(" \n");
        }
        stringBuilder.append("loop ");
        stringBuilder.append(condition);
        stringBuilder.append(" {\n");
        for (Statement block : body) {
            stringBuilder.append(block.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static int loopVarCount = 0;

    @Override
    public Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock, Expression post) {
        Expression strongInvariant = invariant;
        for (Expression expression : postAssertion) {
            strongInvariant = new BinaryExpression(strongInvariant, expression, "&&");
        }

        if (calculatedCondition == null) {
            // prove that "invariant" is loop invariant {pre: condition && invariant} body {post: invariant}
            Expression invExpression = new BinaryExpression(condition, strongInvariant, "&&");
            proveModule.add(invExpression, invariant, body, String.format("Error (invariant doesn't hold) at: %s", getLine()));
            // Check variant, exit condition
            if (variant == Literal.zero) {
                proveModule.onError(String.format("Warning: loop without variant set at: %s", getLine()));
            } else {
                // prove that "variant" is loop variant {pre: condition && invariant && t == z} body {post: t < z}
                OperandName z = loopVar;
                Expression varExpression = new BinaryExpression(invExpression, new BinaryExpression(variant, z, "=="), "&&");
                proveModule.add(varExpression, new BinaryExpression(variant, z, "<"), body, String.format("Warning: loop might not exit (variant is not decreasing) at: %s", getLine()));
                // prove that invariant implies variant >= 0
                proveModule.proveImpl(
                        strongInvariant,
                        new BinaryExpression(variant, new Literal("0"), ">="),
                        String.format("Warning: loop might not exit (variant is not >= 0) at: %s", getLine())
                );
            }
            calculatedCondition = invariant;
        }
        // prove that not condition && invariant => post
        // that is, upon exit of the loop S0, p implies the desired assertion
        proveModule.proveImpl(new BinaryExpression(new UnaryExpression("!", condition), strongInvariant, "&&"),
                post,
                String.format(
                        "Upon exit loop does not imply desired assertion\n" +
                                "At line: %s cannot prove: not condition && invariant => post, where condition: %s, invariant: %s post: %s",
                        line,
                        condition,
                        strongInvariant,
                        post
                )
        );
        // return invariant;
        return calculatedCondition;
    }
}
