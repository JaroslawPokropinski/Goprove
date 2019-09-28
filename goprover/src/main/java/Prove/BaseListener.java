import Antlr.GoproveBaseListener;
import Antlr.GoproveParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class BaseListener extends GoproveBaseListener {
    private List<String> errors = new ArrayList<>();

    private void printChildren(List<ParseTree> tree) {
        for (ParseTree child : tree) {
            System.out.println(child.getText());
        }
    }

    @Override
    public void enterForStmt(GoproveParser.ForStmtContext ctx) {
        super.enterForStmt(ctx);

        if (ctx.expression() != null) {
            printChildren(ctx.expression().children);
        }
    }
}
