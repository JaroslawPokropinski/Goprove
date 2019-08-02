import Expressions.*;

import java.util.ArrayList;
import java.util.List;

public class ProveContext {
    private Expression precondition, postcondition;
    private ArrayList<ProveBlock> toProve = new ArrayList<>();
    private Prover prover = new Prover();
    private List<OperandName> args;

    public class ProveBlock {
        public List<CodeBlock> codeBlocks;
        public Expression precondition, postcondition;

        public ProveBlock(List<CodeBlock> codeBlocks, Expression precondition, Expression postcondition) {
            this.codeBlocks = codeBlocks;
            this.precondition = precondition;
            this.postcondition = postcondition;
        }
    }

    public ProveContext(ProveFunction pfunction) {
        this.precondition = pfunction.getPrecondition();
        this.postcondition = pfunction.getPostcondition();
        this.toProve.add(new ProveBlock(pfunction.getCodeBlocks(), precondition, postcondition));
        this.args = pfunction.getArgs();
    }

    public void add(Expression precondition, Expression postcondition, List<CodeBlock> code) {
        toProve.add(new ProveBlock(code, precondition, postcondition));
    }

    public Expression getPrecondition() {
        return precondition;
    }

    public Expression getPostcondition() {
        return postcondition;
    }

    public Prover getProver() {
        return prover;
    }

    public List<ProveBlock> getToProve() {
        return toProve;
    }

    public List<Boolean> prove() {
        // Calculate assertions
        List<CodeBlock> code = toProve.get(0).codeBlocks;
        List<Expression> assertion = new ArrayList<>();
        for (OperandName op : args) {
           assertion.add(new BinaryExpression(op, new OperandName(String.format("%s'old", op.getName()), op.getType()), "=="));
        }
        for (CodeBlock codeBlock : code) {
            assertion = codeBlock.getForwardAssertion(assertion);
        }

        List<Boolean> boolList = new ArrayList<>(toProve.size());

        for (int j = 0; j < toProve.size(); j++) {
            List<CodeBlock> list = toProve.get(j).codeBlocks;
            Expression postAssertion = toProve.get(j).postcondition;
            for (int i = list.size() - 1; i >= 0; i--) {
                postAssertion = list.get(i).calculateCondition(this, toProve.get(j), postAssertion);
            }
            boolList.add(prover.implies(toProve.get(j).precondition, postAssertion));
        }
        return boolList;
    }
}
