/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;

/**
 * Encapsulatee adapter for a JavaParser constructor expression.
 *
 * @since 0.1
 */
public final class JpConstructor implements Encapsulatee {

    /**
     * JavaParser representation of a constructor expression.
     */
    private final ObjectCreationExpr constructor;

    /**
     * Constructs a constructor representation from a JavaParser concept.
     * @param constructor A JavaParser representation of a constructor.
     */
    public JpConstructor(final ObjectCreationExpr constructor) {
        this.constructor = constructor;
    }

    @Override
    public String name() {
        return this.constructor.getTypeAsString();
    }
}
