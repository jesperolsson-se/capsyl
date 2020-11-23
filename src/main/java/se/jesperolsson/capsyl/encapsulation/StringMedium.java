package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import se.jesperolsson.capsyl.Depth;
import se.jesperolsson.capsyl.SpaceIndentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StringMedium implements Medium {

    private Depth depth;
    private Expression contents;
    private List<Medium> arguments;

    public StringMedium() {
        this(new SpaceIndentation());
    }

    public StringMedium(Depth depth) {
        this(depth, null); // Should use null object, if possible
    }

    public StringMedium(Depth depth, Expression contents) {
        this(depth, contents, new ArrayList<>());
    }

    public StringMedium(Depth depth, Expression contents, List<Medium> arguments) {
        this.depth = depth;
        this.contents = contents;
        this.arguments = arguments;
    }

    private List<Medium> copyChildren() {
        return new LinkedList<>(arguments);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium representParameter(Expression node) {
        return new StringMedium(depth, node, copyChildren());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium nextLevel() {
        return new StringMedium(depth.next(), contents, copyChildren());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium representChild(Medium medium) {
        List<Medium> newChildren = copyChildren();
        newChildren.add(medium);
        return new StringMedium(depth, contents, newChildren);
    }

    @Override
    public String print() {
        String result = depth.print();
        if (contents.isObjectCreationExpr()) {
            result += "Ctor: " + contents.asObjectCreationExpr().getTypeAsString();
        } else if (contents.isLiteralExpr()) {
            result += "Lit: " + contents.toString();
        }
        result += printChildren();
        return result;
    }

    private String printChildren() {
        String result = "";
        for (Medium child : arguments) {
            result += System.lineSeparator() + child.print();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringMedium that = (StringMedium) o;
        return Objects.equals(depth, that.depth) &&
                Objects.equals(contents, that.contents) &&
                Objects.equals(arguments, that.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depth, contents, arguments);
    }
}
