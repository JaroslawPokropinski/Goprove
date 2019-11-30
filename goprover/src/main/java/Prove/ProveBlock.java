package Prove;

import Expressions.Expression;

import java.util.List;

public class ProveBlock {
    private final String error;
    public List<StatementBlock> statementBlocks;
    public Expression precondition, postcondition;

    public ProveBlock(List<StatementBlock> statementBlocks, Expression precondition, Expression postcondition, String error) {
        this.statementBlocks = statementBlocks;
        this.precondition = precondition;
        this.postcondition = postcondition;
        this.error = error;
    }

    Expression calculateCondition(ProveModule proveModule) {
        Expression calculatedAssertion = postcondition;
        for (int i = statementBlocks.size() - 1; i >= 0; i--) {
            calculatedAssertion = statementBlocks.get(i).calculateCondition(proveModule, this, calculatedAssertion);
        }
        return calculatedAssertion;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("{pre: %s}\n", precondition));
        for (StatementBlock cb : statementBlocks) {
            stringBuilder.append(cb);
            stringBuilder.append("\n");
        }
        stringBuilder.append(String.format("{post: %s}\n", postcondition));
        return stringBuilder.toString();
    }

    public String onProveFail() {
        return this.error;
    }
}