import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;

import java.util.List;

public class SourceVisitor extends GoproveBaseVisitor<ProveFunction> {
    @Override
    public ProveFunction visitSourceFile(GoproveParser.SourceFileContext ctx) {
        List<GoproveParser.TopLevelDeclContext> list = ctx.topLevelDecl();
        FunctionVisitor visitor = new FunctionVisitor();
        for (GoproveParser.TopLevelDeclContext topLevelDeclContext : list) {
            if (topLevelDeclContext.proveFunctionDecl() != null) {
                return topLevelDeclContext.proveFunctionDecl().accept(visitor);
            }
        }
        return null;
    }
}
