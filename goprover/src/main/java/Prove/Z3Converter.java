package Prove;

import Expressions.*;
import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

public class Z3Converter extends ExpressionConverter<Expr> {
    private Context ctx;
    public Z3Converter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected Expr onAnd(BinaryExpression binaryExpression) {
        return ctx.mkAnd((BoolExpr)convertExpression(binaryExpression.getLeft()), (BoolExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onOr(BinaryExpression binaryExpression) {
        return ctx.mkOr((BoolExpr)convertExpression(binaryExpression.getLeft()), (BoolExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onLt(BinaryExpression binaryExpression) {
        return ctx.mkLt((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onGt(BinaryExpression binaryExpression) {
        return ctx.mkGt((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onLe(BinaryExpression binaryExpression) {
        return ctx.mkLe((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onGe(BinaryExpression binaryExpression) {
        return ctx.mkGe((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onEq(BinaryExpression binaryExpression) {
        return ctx.mkEq(convertExpression(binaryExpression.getLeft()), convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onNotEq(BinaryExpression binaryExpression) {
        return ctx.mkNot(ctx.mkEq(convertExpression(binaryExpression.getLeft()), convertExpression(binaryExpression.getRight())));
    }

    @Override
    protected Expr onAdd(BinaryExpression binaryExpression) {
        return ctx.mkAdd((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onSub(BinaryExpression binaryExpression) {
        return ctx.mkSub((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onMul(BinaryExpression binaryExpression) {
        return ctx.mkMul((ArithExpr) convertExpression(binaryExpression.getLeft()), (ArithExpr)convertExpression(binaryExpression.getRight()));
    }

    @Override
    protected Expr onSub(UnaryExpression unaryExpression) {
        return ctx.mkSub(ctx.mkInt(0), (ArithExpr)convertExpression(unaryExpression.getExpression()));
    }

    @Override
    protected Expr onNot(UnaryExpression unaryExpression) {
        return ctx.mkNot((BoolExpr)convertExpression(unaryExpression.getExpression()));
    }

    @Override
    protected Expr onLiteral(Literal literal) {
        return ctx.mkInt(literal.getValue());
    }

    @Override
    protected Expr onOperand(OperandName operandName) {
        return ctx.mkIntConst(operandName.getName());
    }

    @Override
    protected Expr onArray(ArrayExpression array) {
        return ctx.mkSelect(
                ctx.mkArrayConst(array.getOperandName().getName(), ctx.getIntSort(), ctx.getIntSort()),
                convertExpression(array.getIndex())
        );
    }

    @Override
    protected Expr onForAll(ForallExpression fe) {
        return ctx.mkForall(
                new Expr[]{convertExpression(fe.getIterator())},
                convertExpression(fe.getExpression()),
                1,
                null,
                null,
                null,
                null
        );
    }

    @Override
    protected Expr onExists(ExistsExpression ex) {
        return ctx.mkExists(
                new Expr[]{convertExpression(ex.getIterator())},
                convertExpression(ex.getExpression()),
                1,
                null,
                null,
                null,
                null
        );
    }
}
