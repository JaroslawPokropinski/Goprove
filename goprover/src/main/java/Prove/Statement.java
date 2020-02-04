package Prove;

import Expressions.Expression;
import Expressions.OperandName;
import java.util.List;

// Interfejs instrukcji
public interface Statement {
    // Zwraca linie kodu na której wystąpiła dana instrukcja.
    // return: linia kodu.
    int getLine();
    // Zwraca warunek początkowy instrukcji dla danego warunku końcowego.
    // parametr: proveContext - kontekst w którym zachodzi dowodzenie.
    // parametr: proveBlock - trójka Hoare'a dla bloku w którym występuje instrukcja.
    // parametr: post - warunek końcowy instrukcji.
    // return: warunek początkowy
    Expression calculateCondition(ProveModule proveModule, ProveBlock proveBlock,
                                  Expression post);
    // Zwraca warunek końcowy instrukcji dla danego warunku początkowego.
    // parametr: prev - lista warunków których koniunkcja jest warunkiem początkowym .
    // return: lista warunków których koniunkcja jest warunkiem końcowym.
    List<Expression> getForwardAssertion(List<Expression> prev);
    // Zwraca liste zmiennych modyfikowanych przez instrukcje.
    // return: lista zmiennych modyfikowanych przez instrukcje.
    List<OperandName> getVariables();
}
