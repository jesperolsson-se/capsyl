/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.JpConstructor;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Represents an encapsulation. That is, something that is being encapsulated plus metadata.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class Encapsulation {

    /**
     * The syntax tree node representing a constructor expression.
     */
    private final Encapsulatee node;

    /**
     * The factory for creating media.
     */
    private final MediaFactory factory;

    /**
     * The name given to the encapsulation.
     */
    private final String name;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     * @param factory The factory to use when creating media.
     */
    public Encapsulation(final ObjectCreationExpr node, final MediaFactory factory) {
        this(node, factory, "Var");
    }

    /**
     * Constructs an encapsulation.
     * @param node An AST node for object creation.
     * @param factory The factory to use when creating media.
     * @param name The name of the encapsulation.
     */
    public Encapsulation(
        final ObjectCreationExpr node,
        final MediaFactory factory,
        final String name) {
        this(new JpConstructor(node, factory, new SpaceIndentation()), factory, name);
    }

    /**
     * Constructs an encapsulation.
     * @param encapsulatee An entity that can be encapsulated.
     * @param factory The factory to use when creating media.
     * @param name The name of the encapsulation.
     */
    public Encapsulation(
        final Encapsulatee encapsulatee,
        final MediaFactory factory,
        final String name) {
        this.node = encapsulatee;
        this.factory = factory;
        this.name = name;
    }

    /**
     * Asks the encapsulation to represent itself.
     * @return A medium containing a representation of this object.
     */
    public Medium represent() {
        return this.factory.encapsulation()
            .representEncapsulatee(this.node)
            .representName(this.name);
    }
}
