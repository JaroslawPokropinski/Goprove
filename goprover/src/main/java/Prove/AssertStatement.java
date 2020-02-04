package Prove;
// TODO: Fix precondition inside loop?
import Expressions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssertStatement implements Statement {
    private Expression expression;
    private int line;
    private boolean first = true;

    public AssertStatement(int line, Expression accept) {
        expression = accept;
        this.line = line;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return String.format("Assert: %s", expression.toString());
    }

    @Override
    public Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock, Expression post) {
        List<Statement> statements = new ArrayList<>();
        for (int i = 0; i < proveBlock.statements.size() && proveBlock.statements.get(i) != this; i++) {
            statements.add(proveBlock.statements.get(i));
        }
        if (first) {
            String failMessage = String.format("Failed to prove assertion at line: %d", getLine());
            proveModule.add(proveBlock.precondition, expression, statements, failMessage);
            first = false;
        }
        return post;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        prev.add(expression);
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        return Collections.emptyList();
    }
}
