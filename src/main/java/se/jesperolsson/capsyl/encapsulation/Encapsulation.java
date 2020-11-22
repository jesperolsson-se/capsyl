package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import se.jesperolsson.capsyl.Depth;
import se.jesperolsson.capsyl.SpaceIndentation;

/**
 * Represents an object's encapsulation.
 */
public class Encapsulation {

    private final ObjectCreationExpr node;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     */
    public Encapsulation(ObjectCreationExpr node) {

        this.node = node;
    }

    public String represent() {
        return represent(node, new SpaceIndentation());
    }

    private String represent(ObjectCreationExpr constructor, Depth depth) {
        String result = depth.print() + "Ctor: " + constructor.getTypeAsString();
        result += System.lineSeparator();

        NodeList<Expression> arguments = constructor.getArguments();
        for(Expression expression : arguments) {
            if (!expression.isObjectCreationExpr()) {
                result += depth.next().print() + "Inner: " + expression.toString();
            } else {
                ObjectCreationExpr inner = expression.asObjectCreationExpr();
                result += represent(inner, depth.next());
                result += System.lineSeparator();
            }
        }
        return result;
    }
}
