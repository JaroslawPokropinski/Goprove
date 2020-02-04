package Prove;

import Expressions.*;
import java.util.ArrayList;
import java.util.List;

public class ProveModule {
    private Prover prover = null;
    private ArrayList<ProveBlock> toProve;
    public List<String> errors = new ArrayList<>();
    private List<Boolean> boolList = new ArrayList<>();
    private Expression precondition;
    private Expression postcondition;
    private List<Statement> code;
    private List<OperandName> args;

    public ProveModule(Expression precondition, Expression postcondition,
                       List<Statement> code, List<OperandName> args, boolean verbose) {
        this.precondition = precondition;
        this.postcondition = postcondition;
        this.code = code;
        this.args = args;
        prover = new Z3Prover(verbose);
    }

    void add(Expression precondition, Expression postcondition,
             List<Statement> code, String error) {
        toProve.add(new ProveBlock(code, precondition, postcondition, error));
    }

    private List<Expression> getAssertionList(Expression expression) {
        if (expression instanceof BinaryExpression) {
            BinaryExpression be = (BinaryExpression) expression;
            if (be.getBinaryOperator().equals("&&")) {
                List<Expression> l = new ArrayList<>();
                l.addAll(getAssertionList(be.getLeft()));
                l.addAll(getAssertionList(be.getRight()));
                return l;
            }
        }
        List<Expression> l = new ArrayList<>(1);
        l.add(expression);
        return l;
    }

    void onError(String error) {
        errors.add(error);
        boolList.add(false);
    }

    private void onSuccess() {
        boolList.add(true);
    }

    void proveImpl(Expression left, Expression right, String error) {
        if(!prover.implies(left, right)) {
            onError(error);
        }
    }

    public List<Boolean> prove() {
        // Calculate assertions
        toProve = new ArrayList<>();
        add(precondition, postcondition, code, "Failed to prove postcondition!");
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
        // add precondition to assertion
        assertion.clear();
        assertion.addAll(getAssertionList(toProve.get(0).precondition));

        for (Statement statement : code) {
            assertion = statement.getForwardAssertion(assertion);
        }

        boolList.clear();

        for (int j = 0; j < toProve.size(); j++) {
            Expression calculatedAssertion = toProve.get(j).calculateCondition(this);
            boolean im = prover.implies(toProve.get(j).precondition, calculatedAssertion);
            if(!im) {
                onError(toProve.get(j).onProveFail());
            } else {
                onSuccess();
            }
        }
        return boolList;
    }
}
