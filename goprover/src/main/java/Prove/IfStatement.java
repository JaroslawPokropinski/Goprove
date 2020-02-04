package Prove;

import Expressions.BinaryExpression;
import Expressions.Expression;
import Expressions.OperandName;
import Expressions.UnaryExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IfStatement implements Statement {

    private int line;
    private Expression condition;
    private List<Statement> body;
    private List<Statement> elBody;
    private List<OperandName> var = null;

    public IfStatement(int line, Expression condition, List<Statement> body) {
        this(line, condition, body, null);
    }

    public IfStatement(int line, Expression condition, List<Statement> body, List<Statement> elBody) {
        if (condition == null || body == null) {
            throw new NullPointerException("At line: " + line);
        }
        for (Statement st : body) {
            if (st == null) {
                throw new NullPointerException("At line: " + line);
            }
        }
        if (elBody != null) {
            for (Statement st : elBody) {
                if (st == null) {
                    throw new NullPointerException("At line: " + line);
                }
            }
        }
        this.line = line;
        this.condition = condition;
        this.body = body;
        this.elBody = elBody;
    }

    @Override
    public Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock, Expression post) {
        Expression left, right;
        if (elBody == null) {
            left = new BinaryExpression(new UnaryExpression("!", condition), post, "&&");
        } else {
            Expression elBodyAssertion = post;
            for (int i = elBody.size() - 1; i >= 0; i--) {
                elBodyAssertion = elBody.get(i).calculateCondition(proveModule, proveBlock, elBodyAssertion);
            }
            left = new BinaryExpression(new UnaryExpression("!", condition), elBodyAssertion, "&&");
        }

        Expression bodyAssertion = post;
        for (int i = body.size() - 1; i >= 0; i--) {
            bodyAssertion = body.get(i).calculateCondition(proveModule, proveBlock, bodyAssertion);
        }
        right = new BinaryExpression(condition, bodyAssertion, "&&");
        return new BinaryExpression(left, right, "||");
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        // TODO: recursion for body and elBody
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
        return prev;
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
            if (elBody != null) {
                for (Statement statement : elBody) {
                    statement
                            .getVariables()
                            .forEach((v) -> {
                                if (!var.contains(v)) {
                                    var.add(v);
                                }
                            });
                }
            }
        }
        return var;
    }
}
