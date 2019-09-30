package Prove;

import Expressions.Expression;
import Expressions.OperandName;

import java.util.Collections;
import java.util.List;

public class EmptyBlock implements StatementBlock {

    private int line;
    public EmptyBlock(int line) {
        this.line = line;
    }

    @Override
    public Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post) {
        return post;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        return Collections.emptyList();
    }
}
