package Prove;

import Expressions.Expression;
import Expressions.OperandName;

import java.util.Collections;
import java.util.List;

public class ReturnBlock implements StatementBlock {
    private int line;

    public ReturnBlock(int line) {
        this.line = line;
    }

    @Override
    public Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock, Expression post) {
        return post;
    }

    @Override
    public String toString() {
        return "return";
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public List<Expression> getForwardAssertion(List<Expression> prev) {
        prev.clear();
        return prev;
    }

    @Override
    public List<OperandName> getVariables() {
        return Collections.emptyList();
    }
}
