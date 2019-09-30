package Prove;

import Expressions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoopBlock implements StatementBlock {
    private Expression condition;
    private List<StatementBlock> body;
    private Expression invariant;
    private int line;
    private List<OperandName> var = null;
    private List<Expression> postAssertion = new ArrayList<>();

    public LoopBlock(int line, Expression condition, List<StatementBlock> body, Expression invariant) {
        if (condition == null) {
            throw new NullPointerException("At line: " + line);
        }
        if (body == null) {
            throw new NullPointerException("At line: " + line);
        }
        if (invariant == null) {
            throw new NullPointerException("At line: " + line);
        }
        this.line = line;
        this.condition = condition;
        this.body = body;
        this.invariant = invariant;
    }

    @Override
    public List<OperandName> getVariables() {
        if (var == null) {
            var = new ArrayList<>();
            for (StatementBlock statementBlock : body) {
                statementBlock
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
        postAssertion.addAll(prev);
        // TODO : In the loop assertions
        return prev;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (invariant != null) {
            stringBuilder.append("inv ");
            stringBuilder.append(invariant);
            stringBuilder.append(" {\n");
        }
        stringBuilder.append("loop ");
        stringBuilder.append(condition);
        stringBuilder.append(" {\n");
        for (StatementBlock block : body) {
            stringBuilder.append(block.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post) {
        // prove that "invariant" is loop invariant {pre: condition && invariant} body {post: invariant}
        proveContext.add(new BinaryExpression(condition, invariant, "&&"), invariant, body);
        // prove that not condition && invariant => post
        Expression strongInvariant = invariant;
        for (Expression expression : postAssertion) {
            strongInvariant = new BinaryExpression(strongInvariant, expression, "&&");
        }
        // that is, upon exit of the loop S0, p implies the desired assertion
        if (!proveContext.getProver().implies(new BinaryExpression(new UnaryExpression("!", condition), strongInvariant, "&&"), post)) {
            System.out.println(String.format(
                    "Upon exit loop does not imply desired assertion\n" +
                    "At line: %s cannot prove: not condition && invariant => post, where condition: %s, invariant: %s post: %s",
                    line,
                    condition,
                    strongInvariant,
                    post
            ));
            proveContext.boolList.add(false);
        }
        return invariant;
    }
}
