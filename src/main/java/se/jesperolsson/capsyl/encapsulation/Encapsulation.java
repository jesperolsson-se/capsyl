/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.NullMedium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Represents an object's encapsulation.
 *
 * @since 0.1
 */
public class Encapsulation {

    /**
     * The syntax tree node representing a constructor expression.
     */
    private final ObjectCreationExpr node;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     */
    public Encapsulation(final ObjectCreationExpr node) {
        this.node = node;
    }

    /**
     * Asks the encapsulation to represent itself in its preferred medium.
     * @return A medium containing a representation of this object.
     */
    public Medium represent() {
        return this.represent(new TreeMedium());
    }

    /**
     * Asks the encapsulation to represent itself in the provided medium.
     * @param medium The medium in which the object should represent itself.
     * @return A copy of the original medium, also containing a representation of this object.
     */
    public Medium represent(final Medium medium) {
        final Encapsulatee constructor = new JpConstructor(this.node);
        return this.children(
            medium.representEncapsulatee(constructor),
            medium.nextLevel()
        );
    }

    /**
     * Asks the encapsulation to just represent its children in the provided medium.
     * @param medium The medium in which the object should represent its children.
     * @param level The level at which the children should be represented.
     * @return A copy of the original medium, also containing a representation of the children.
     */
    public Medium children(final Medium medium, final Medium level) {
        return this.node.getArguments()
            .stream()
            .map(expression -> child(expression, level))
            .reduce(medium, (next, child) -> next.representChild(child));
    }

    /**
     * Asks the encapsulation to just represent the specified child in the provided medium.
     * @param parameter The child to represent.
     * @param level The level at which the child should be represented.
     * @return A medium containing a representation of the child.
     */
    public static Medium child(final Expression parameter, final Medium level) {
        Medium result = new NullMedium();
        if (parameter.isObjectCreationExpr()) {
            final ObjectCreationExpr constructor = parameter.asObjectCreationExpr();
            result = new Encapsulation(constructor).represent(level);
        } else if (parameter.isLiteralExpr()) {
            result = level.representEncapsulatee(
                new JpLiteral(parameter.asLiteralExpr())
            );
        }
        return result;
    }
}
