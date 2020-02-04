package Prove;

import Expressions.Expression;
import java.util.List;

public class ProveBlock {
    private final String error;
    // Ciąg instrukcji.
    List<Statement> statements;
    // Warunek początkowy i końcowy.
    Expression precondition, postcondition;

    public ProveBlock(List<Statement> statements, Expression precondition,
                      Expression postcondition, String error) {
        this.statements = statements;
        this.precondition = precondition;
        this.postcondition = postcondition;
        this.error = error;
    }

    // Oblicza warunek początkowy dla ciągu instrukcji
    // parametr: proveModule - moduł dowodzenia.
    // return: warunek początkowy dla ciągu instrukcji.
    Expression calculateCondition(ProveModule proveModule) {
        Expression calculatedAssertion = postcondition;
        for (int i = statements.size() - 1; i >= 0; i--) {
            calculatedAssertion = statements.get(i).calculateCondition(proveModule, this, calculatedAssertion);
        }
        return calculatedAssertion;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("{pre: %s}\n", precondition));
        for (Statement cb : statements) {
            stringBuilder.append(cb);
            stringBuilder.append("\n");
        }
        stringBuilder.append(String.format("{post: %s}\n", postcondition));
        return stringBuilder.toString();
    }
    // Zwraca treść błędu
    String onProveFail() {
        return this.error;
    }
}