package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;

/**
 * Encapsulatee adapter for a JavaParser constructor expression.
 */
public class JpConstructor implements Encapsulatee {

    private final ObjectCreationExpr constructor;

    public JpConstructor(ObjectCreationExpr constructor) {
        this.constructor = constructor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return constructor.getTypeAsString();
    }
}
