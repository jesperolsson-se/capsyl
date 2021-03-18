/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import java.util.LinkedList;
import java.util.List;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.MediaFactory;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;

/**
 * Encapsulatee adapter for a JavaParser constructor expression.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class JpConstructor implements Encapsulatee {

    /**
     * JavaParser representation of a constructor expression.
     */
    private final ObjectCreationExpr constructor;

    /**
     * The factory for creating media.
     */
    private final MediaFactory factory;

    /**
     * The object's depth in the encapsulation.
     */
    private final Depth depth;

    /**
     * Constructs a constructor representation from a JavaParser concept.
     * @param constructor A JavaParser representation of a constructor
     * @param factory The factory to use when creating media.
     * @param depth The object's depth in the encapsulation.
     */
    public JpConstructor(
        final ObjectCreationExpr constructor,
        final MediaFactory factory,
        final Depth depth) {
        this.constructor = constructor;
        this.factory = factory;
        this.depth = depth;
    }

    @Override
    public Medium represent() {
        return this.factory.encapsulatee()
            .representName(this.constructor.getTypeAsString())
            .representChildren(this.children())
            .withDepth(this.depth);
    }

    /**
     * Asks the object to parse its sub-encapsulatees, if any.
     * @return The constructor's child encapsulatees.
     */
    public Encapsulatees children() {
        final List<Encapsulatee> result = new LinkedList<>();
        for (final Expression parameter : this.constructor.getArguments()) {
            if (parameter.isObjectCreationExpr()) {
                result.add(
                    new JpConstructor(
                        parameter.asObjectCreationExpr(),
                        this.factory,
                        this.depth.next()
                    )
                );
            } else if (parameter.isLiteralExpr()) {
                result.add(
                    new JpLiteral(
                        parameter.asLiteralExpr(),
                        this.factory,
                        this.depth.next()
                    )
                );
            }
        }
        return new SimpleEncapsulatees(this.factory, result);
    }
}
