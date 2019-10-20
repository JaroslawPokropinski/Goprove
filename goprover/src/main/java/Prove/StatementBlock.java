package Prove;

import Expressions.Expression;
import Expressions.OperandName;

import java.util.List;

public interface StatementBlock {
    Expression calculateCondition(ProveContext proveContext, ProveBlock proveBlock, Expression post);
    int getLine();
    List<Expression> getForwardAssertion(List<Expression> prev);
    List<OperandName> getVariables();
}
