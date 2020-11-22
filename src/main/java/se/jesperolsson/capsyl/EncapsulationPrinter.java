package se.jesperolsson.capsyl;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class EncapsulationPrinter extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(VariableDeclarator md, Void arg) {
        /* Satisfies, e.g.,
           Foo a = new Apa(new Bepa());
        */

        super.visit(md, arg);
        List<Node> children = md.getChildNodes();
        for (Node child: children) {
            if (child instanceof ObjectCreationExpr) {  // This should happen exactly zero or one times.
                ObjectCreationExpr constructor = ((ObjectCreationExpr) child);
                processConstructor(constructor, 0);
            }
        }
    }

    @Override
    public void visit(AssignExpr md, Void arg) {
        /* Satisfies, e.g.,
           Foo foo;
           foo = new Apa(new Bepa());
         */

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