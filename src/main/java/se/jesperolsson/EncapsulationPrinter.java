package se.jesperolsson;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class EncapsulationPrinter extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(AssignExpr md, Void arg) {
        super.visit(md, arg);
        if (md.getValue().isObjectCreationExpr()) {
            ObjectCreationExpr constructor = md.getValue().asObjectCreationExpr();
            processConstructor(constructor, 0);
        }
    }

    private void processConstructor(ObjectCreationExpr constructor, int depth) {
        String indentation = "";
        for (int i = 0; i < depth; i++) {
            indentation += "  ";
        }

        System.out.println(indentation + "Ctor: " + constructor.getTypeAsString());
        NodeList<Expression> arguments = constructor.getArguments();
        for(Expression expression : arguments) {
            if (!expression.isObjectCreationExpr()) {
                indentation += "  "; // depth++
                System.out.println(indentation + "Inner: " + expression.toString());
            } else {
                ObjectCreationExpr inner = expression.asObjectCreationExpr();
                processConstructor(inner, depth + 1);
            }
        }
    }
}
