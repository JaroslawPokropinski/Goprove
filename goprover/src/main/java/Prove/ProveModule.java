package Prove;

import Expressions.*;
import java.util.ArrayList;
import java.util.List;

// Klasa modułu dowodzącego.
public class ProveModule {
    // Obiekt sprawdający poprawność implikacji.
    private Prover prover = new Z3Prover();
    // Lista trójek Hoaer'a do udowodnienia.
    private ArrayList<ProveBlock> toProve;
    // Lista z wynikami dowodzenia.
    private List<Boolean> boolList = new ArrayList<>();
    // Warunek początkowy funkcji.
    private Expression precondition;
    // Warunek końcowy funkcji.
    private Expression postcondition;
    // Lista instrukcji funkcji.
    private List<StatementBlock> code;
    // Lista argumentów funkcji.
    private List<OperandName> args;

    // parametr: precondition - warunek początkowy funkcji.
    // parametr: postcondition - warunek końcowy funkcji.
    // parametr: code - lista instrukcji funkcji .
    // parametr: args - argumenty funkcji.
    public ProveModule(Expression precondition, Expression postcondition,
                       List<StatementBlock> code, List<OperandName> args) {
        this.precondition = precondition;
        this.postcondition = postcondition;
        this.code = code;
        this.args = args;
    }

    // Dodaje trójkę do listy trójek do dowiedzenia
    // parametr: precondition - warunek początkowy.
    // parametr: postcondition - warunek końcowy.
    // parametr: code - lista instrukcji.
    // parametr: error - tekst błędu jeśli dowodzenie się nie powiedzie.
    void add(Expression precondition, Expression postcondition,
               List<StatementBlock> code, String error) {
        toProve.add(new ProveBlock(code, precondition, postcondition, error));
    }

    // Dzieli koniunkcje na liste wyrażeń.
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

    // Funkcja wykonująca się podczas błędu dowodzenia.
    void onError(String error) {
        System.out.println(error);
        boolList.add(false);
    }

    // Funkcja wykonująca się podczas błędu dowodzenia.
    private void onSuccess() {
        boolList.add(true);
    }

    // Dowodzi implikacje za pomocą obiektu prover.
    void proveImpl(Expression left, Expression right, String error) {
        if(!prover.implies(left, right)) {
            onError(error);
        }
    }

    // Dowodzi trójki na liście toProve.
    // return: Lista z wynikami dowodzenia.
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
        assertion.addAll(getAssertionList(toProve.get(0).precondition));

        for (StatementBlock statementBlock : code) {
            assertion = statementBlock.getForwardAssertion(assertion);
        }

        boolList.clear();

        for (int j = 0; j < toProve.size(); j++) {
            List<StatementBlock> list = toProve.get(j).statementBlocks;
            Expression calculatedAssertion = toProve.get(j).calculateCondition(this);
//            Expression postAssertion = toProve.get(j).postcondition;
//            for (int i = list.size() - 1; i >= 0; i--) {
//                postAssertion = list.get(i).calculateCondition(this, toProve.get(j), postAssertion);
//            }
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
