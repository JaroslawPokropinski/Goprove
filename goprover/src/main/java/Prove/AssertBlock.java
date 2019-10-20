package Prove;
// TODO: Fix precondition inside loop?
import Expressions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssertBlock implements StatementBlock {
    private Expression expression;
    private int line;
    private boolean first = true;

    public AssertBlock(int line, Expression accept) {
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
    public Expression calculateCondition(ProveContext proveContext, ProveBlock proveBlock, Expression post) {
        List<StatementBlock> statementBlocks = new ArrayList<>();
        for (int i = 0; i < proveBlock.statementBlocks.size() && proveBlock.statementBlocks.get(i) != this; i++) {
            statementBlocks.add(proveBlock.statementBlocks.get(i));
        }
        if (first) {
            String failMessage = String.format("Failed to prove assertion at line: %d", getLine());
            proveContext.add(proveBlock.precondition, expression, statementBlocks, failMessage);
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
