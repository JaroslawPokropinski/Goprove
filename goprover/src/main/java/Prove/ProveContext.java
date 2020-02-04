package Prove;

import java.util.*;
import Expressions.*;


public class ProveContext {
    private ArrayList<ProveBlock> toProve = new ArrayList<>();
    private List<OperandName> args;
    private Map<String, OperandName> declarationTable = new HashMap<>();
    public ProveModule proveModule = null;
    private boolean verbose;

    public ProveContext(boolean verbose) {
        this.verbose = verbose;
    }

    public void create(Expression precondition, Expression postcondition,
                       List<Statement> code, List<OperandName> args) {
        proveModule = new ProveModule(precondition, postcondition, code, args, verbose);
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
