import Antlr.GoproveBaseVisitor;
import Antlr.GoproveParser;
import Prove.ProveContext;

import java.util.List;

public class SourceVisitor extends GoproveBaseVisitor<ProveFunction> {

    private ProveContext proveContext;
    public SourceVisitor(ProveContext proveContext) {
        super();
        this.proveContext = proveContext;
    }

    @Override
    public ProveFunction visitSourceFile(GoproveParser.SourceFileContext ctx) {
        List<GoproveParser.TopLevelDeclContext> list = ctx.topLevelDecl();
        FunctionVisitor visitor = new FunctionVisitor(proveContext);
        for (GoproveParser.TopLevelDeclContext topLevelDeclContext : list) {
            if (topLevelDeclContext.proveFunctionDecl() != null) {
                return topLevelDeclContext.proveFunctionDecl().accept(visitor);
            }
        }
        return null;
    }
}
