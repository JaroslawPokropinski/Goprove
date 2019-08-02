import Expressions.*;
import com.microsoft.z3.*;


public class Prover {
    Context ctx = new Context();
    public boolean implies(Expression left, Expression right) {
        Solver solver = ctx.mkSolver();
        BoolExpr implication = ctx.mkImplies((BoolExpr) convertExpression(left), (BoolExpr)convertExpression(right));
        solver.add(ctx.mkNot(implication));
        return solver.check() == Status.UNSATISFIABLE;
    }

    private Expr convertExpression(Expression expression) {
        // TODO: Error in conversion
        if (expression instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) expression;
            switch (binaryExpression.getBinaryOperator()) {
                case "&&":
                    return ctx.mkAnd((BoolExpr)convertExpression(binaryExpression.getLeft()), (BoolExpr)convertExpression(binaryExpression.getRight()));
                case "||":
                    return ctx.mkOr((BoolExpr)convertExpression(binaryExpression.getLeft()), (BoolExpr)convertExpression(binaryExpression.getRight()));
                case "<":
                    return ctx.mkLt((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
                case ">=":
                    return ctx.mkGe((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
                case "==":
                    return ctx.mkEq(convertExpression(binaryExpression.getLeft()), convertExpression(binaryExpression.getRight()));
                case "!=":
                    return ctx.mkNot(ctx.mkEq(convertExpression(binaryExpression.getLeft()), convertExpression(binaryExpression.getRight())));
                case "+":
                    return ctx.mkAdd((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
                case "-":
                    return ctx.mkSub((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
                case "*":
                    return ctx.mkMul((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
                default:
                    throw new RuntimeException(String.format("Unsupported binary expression '%s'", binaryExpression.getBinaryOperator()));
            }
        }
        if (expression instanceof UnaryExpression) {
            UnaryExpression unaryExpression = (UnaryExpression) expression;
            switch (unaryExpression.getOperator()) {
                case "-":
                    return ctx.mkSub(ctx.mkInt(0), (ArithExpr)convertExpression(unaryExpression.getExpression()));
                case "!":
                    return ctx.mkNot((BoolExpr)convertExpression(unaryExpression.getExpression()));
                default:
                    throw new RuntimeException(String.format("Unsupported unary expression '%s'", unaryExpression.getOperator()));
            }
        }
        if (expression instanceof Literal) {
            Literal literal = (Literal) expression;
            return ctx.mkInt(literal.getValue());
        }
        if (expression instanceof OperandName) {
            OperandName operandName = (OperandName) expression;
            return ctx.mkIntConst(operandName.getName());
        }
        throw new RuntimeException("Unsupported type of expression");
    }
}
