package Prove;

import java.util.*;
import Expressions.*;


// Klasa konteksu dowodzenia pośrednicząca między parserem a modułem dowodzącym
public class ProveContext {
    // Lista trójek Hoaer'a do udowodnienia
    private ArrayList<ProveBlock> toProve = new ArrayList<>();
    // Obiekt sprawdający poprawność implikacji
    private Prover prover = new Z3Prover();
    // Lista argumentów funkcji
    private List<OperandName> args;
    // Mapa zadeklarowanych zmiennych i odpowiadających im obiektów.
    private Map<String, OperandName> declarationTable = new HashMap<>();
    // Lista z wynikami dowodzenia


    public ProveModule proveModule = null;

    // Tworzy moduł dowodzenia dla danej funkcji.
    // parametr: precondition - warunek początkowy funkcji.
    // parametr: postcondition - warunek końcowy funkcji.
    // parametr: code - lista instrukcji funkcji .
    // parametr: args - argumenty funkcji.
    public void create(Expression precondition, Expression postcondition,
                       List<StatementBlock> code, List<OperandName> args) {
        proveModule = new ProveModule(precondition, postcondition, code, args);
    }

    public void declareVariable(OperandName op) {
        if (declarationTable.containsKey(op.getName())) {
            throw new RuntimeException(String.format("Variable %s already defined!", op.getName()));
        }
        declarationTable.put(op.getName(), op);
    }

    public void undeclareVariable(String op) {
        if (!declarationTable.containsKey(op)) {
            throw new RuntimeException(String.format("Variable %s is not defined (cannot be undeclared)!", op));
        }
        declarationTable.remove(op);
    }

    public OperandName getVariable(String op) {
        if (!declarationTable.containsKey(op)) {
            throw new RuntimeException(String.format("Variable %s is not defined!", op));
        }
        return declarationTable.get(op);
    }

    public List<Boolean> prove() {
        return proveModule.prove();
    }
}
