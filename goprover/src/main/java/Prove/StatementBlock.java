package Prove;

import Expressions.Expression;
import Expressions.OperandName;
import Prove.ProveContext;

import java.util.List;

public interface CodeBlock {
    Expression calculateCondition(ProveContext proveContext, ProveContext.ProveBlock proveBlock, Expression post);
    int getLine();
    List<Expression> getForwardAssertion(List<Expression> prev);
    List<OperandName> getVariables();
}
