package Prove;

import Expressions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProveContext {
    private ArrayList<ProveBlock> toProve = new ArrayList<>();
    private Prover prover = new Z3Prover();
    private List<OperandName> args;
    private Map<String, OperandName> declarationTable = new HashMap<>();
    public List<Boolean> boolList = new ArrayList<>();

    public ProveContext(){}

    public void create(Expression precondition, Expression postcondition, List<StatementBlock> code, List<OperandName> args) {
        this.toProve.add(new ProveBlock(code, precondition, postcondition));
        this.args = args;
    }



    public void add(Expression precondition, Expression postcondition, List<StatementBlock> code) {
        toProve.add(new ProveBlock(code, precondition, postcondition));
    }

    public Prover getProver() {
        return prover;
    }

    public void declareVariable(OperandName op) {
        if (declarationTable.containsKey(op.getName())) {
            throw new RuntimeException(String.format("Variable %s already defined", op.getName()));
        }
        declarationTable.put(op.getName(), op);
    }

    public void undeclareVariable(String op) {
        if (!declarationTable.containsKey(op)) {
            throw new RuntimeException(String.format("Variable %s is not defined (cannot be undeclared)", op));
        }
        declarationTable.remove(op);
    }

    public boolean hasVariable(String op) {
        return declarationTable.containsKey(op);
    }

    public OperandName getVariable(String op) {
        if (!declarationTable.containsKey(op)) {
            throw new RuntimeException(String.format("Variable %s is not defined", op));
        }
        return declarationTable.get(op);
    }

    public List<Boolean> prove() {
        // Calculate assertions
        List<StatementBlock> code = toProve.get(0).statementBlocks;
        List<Expression> assertion = new ArrayList<>();
        for (OperandName op : args) {
            if (op.getType().equals("int")) {
                assertion.add(new BinaryExpression(
                        op,
                        new OperandName(String.format("%s'old", op.getName())),
                        "=="
                ));
            }
            else {
                OperandName oldIter = new OperandName(String.format("%s'olditer", op.getName()));
                assertion.add(new ForallExpression(
                        oldIter,
                        new BinaryExpression(
                                new ArrayExpression(op, oldIter),
                                new ArrayExpression(new OperandName(String.format("%s'old", op.getName())), oldIter),
                                "=="
                        )
                ));
            }
        }
        for (Expression e : assertion) {
            toProve.get(0).precondition = new BinaryExpression(toProve.get(0).precondition, e, "&&");
        }
        for (StatementBlock statementBlock : code) {
            assertion = statementBlock.getForwardAssertion(assertion);
        }

        boolList.clear();

        for (int j = 0; j < toProve.size(); j++) {
            List<StatementBlock> list = toProve.get(j).statementBlocks;
            Expression postAssertion = toProve.get(j).postcondition;
            for (int i = list.size() - 1; i >= 0; i--) {
                postAssertion = list.get(i).calculateCondition(this, toProve.get(j), postAssertion);
            }
            boolean im = prover.implies(toProve.get(j).precondition, postAssertion);
            if(!im) {
                System.out.println(String.format("Error (invariant doesn't hold) at: %s", list.get(0).getLine()));
            }
            boolList.add(im);
        }
        return boolList;
    }

    public static class ProveBlock {
        public List<StatementBlock> statementBlocks;
        public Expression precondition, postcondition;

        public ProveBlock(List<StatementBlock> statementBlocks, Expression precondition, Expression postcondition) {
            this.statementBlocks = statementBlocks;
            this.precondition = precondition;
            this.postcondition = postcondition;
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
    }
}
