package Prove;

import Expressions.Expression;
import Expressions.OperandName;

import java.util.List;

public class ProveFunction {
    private List<StatementBlock> statementBlocks;
    private List<OperandName> args;
    private List<String> returns;
    private Expression  precondition, postcondition;

    // TODO: are args and returns useless?

    public ProveFunction(List<StatementBlock> statementBlocks, List<OperandName> args, List<String> returns, Expression precondition, Expression postcondition) {
        this.statementBlocks = statementBlocks;
        this.args = args;
        this.returns = returns;
        this.precondition = precondition;
        this.postcondition = postcondition;
    }

    public List<StatementBlock> getStatementBlocks() {
        return statementBlocks;
    }

    public List<OperandName> getArgs() {
        return args;
    }

    public List<String> getReturns() {
        return returns;
    }

    public Expression getPrecondition() {
        return precondition;
    }

    public Expression getPostcondition() {
        return postcondition;
    }
}
