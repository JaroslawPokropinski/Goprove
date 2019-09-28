import Expressions.Expression;
import Expressions.OperandName;

import java.util.List;

public class ProveFunction {
    private List<CodeBlock> codeBlocks;
    private List<OperandName> args;
    private List<String> returns;
    private Expression  precondition, postcondition;

    public ProveFunction(List<CodeBlock> codeBlocks, List<OperandName> args, List<String> returns, Expression precondition, Expression postcondition) {
        this.codeBlocks = codeBlocks;
        this.args = args;
        this.returns = returns;
        this.precondition = precondition;
        this.postcondition = postcondition;
    }

    public List<CodeBlock> getCodeBlocks() {
        return codeBlocks;
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
