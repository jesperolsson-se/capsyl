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
import se.jesperolsson.capsyl.name.Mononym;
import se.jesperolsson.capsyl.name.Name;

/**
 * Represents an encapsulation that has a name.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NamedEncapsulation implements Encapsulation {

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
    private final Name name;

    /**
     * Constructs an encapsulation from a construction statement.
     * @param node An AST node for object creation.
     * @param factory The factory to use when creating media.
     */
    public NamedEncapsulation(final ObjectCreationExpr node, final MediaFactory factory) {
        this(node, factory, new Mononym("Var"));
    }

    /**
     * Constructs an encapsulation.
     * @param node An AST node for object creation.
     * @param factory The factory to use when creating media.
     * @param name The name of the encapsulation.
     */
    public NamedEncapsulation(
        final ObjectCreationExpr node,
        final MediaFactory factory,
        final Name name) {
        this(new JpConstructor(node, factory, new SpaceIndentation()), factory, name);
    }

    /**
     * Constructs an encapsulation.
     * @param encapsulatee An entity that can be encapsulated.
     * @param factory The factory to use when creating media.
     * @param name The name of the encapsulation.
     */
    public NamedEncapsulation(
        final Encapsulatee encapsulatee,
        final MediaFactory factory,
        final Name name) {
        this.node = encapsulatee;
        this.factory = factory;
        this.name = name;
    }

    @Override
    public Medium represent() {
        return this.factory.encapsulation()
            .representEncapsulatee(this.node)
            .representName(this.name);
    }
}
