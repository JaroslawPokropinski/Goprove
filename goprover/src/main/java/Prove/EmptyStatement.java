package Prove;

import Expressions.Expression;
import Expressions.OperandName;

import java.util.Collections;
import java.util.List;

public class EmptyStatement implements Statement {

    private int line;
    public EmptyStatement(int line) {
        this.line = line;
    }

    @Override
    public Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock, Expression post) {
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
