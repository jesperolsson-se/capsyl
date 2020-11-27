package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

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

    public Medium represent() {
        return represent(new TreeMedium());
    }

    public Medium represent(Medium medium) {
        /* When we the represent our encapsulation, we choose to do so in a bottom-up fashion.
           This is a recursive method that ask each child to represent itself on
           the next level of the encapsulation hierarchy. */
        Medium nextLevel = medium.nextLevel();
        for (Expression parameter : node.getArguments()) {
            if (parameter.isObjectCreationExpr()) {
                ObjectCreationExpr constructor = parameter.asObjectCreationExpr();
                Medium next = new Encapsulation(constructor).represent(nextLevel);
                medium = medium.representChild(next);
            } else if (parameter.isLiteralExpr()) {
                Medium next = nextLevel.representEncapsulatee(
                        new JpLiteral(parameter.asLiteralExpr())
                );
                medium = medium.representChild(next);
            }
        }

        medium = medium.representEncapsulatee(new JpConstructor(node));

        return medium;
    }

}
