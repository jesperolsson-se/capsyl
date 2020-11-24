package se.jesperolsson.capsyl.encapsulation;

import se.jesperolsson.capsyl.Depth;
import se.jesperolsson.capsyl.SpaceIndentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StringMedium implements Medium {

    private final Depth depth;
    private final Encapsulatee contents;
    private final List<Medium> arguments;

    public StringMedium() {
        this(new SpaceIndentation());
    }

    public StringMedium(Depth depth) {
        this(depth, new NullEncapsulatee());
    }

    public StringMedium(Depth depth, Encapsulatee contents) {
        this(depth, contents, new ArrayList<>());
    }

    public StringMedium(Depth depth, Encapsulatee contents, List<Medium> arguments) {
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
    public Medium representParameter(Encapsulatee encapsulatee) {
        return new StringMedium(depth, encapsulatee, copyChildren());
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
        result += "Param: " + contents.name();
        result += printChildren();
        return result;
    }

    private String printChildren() {
        StringBuilder result = new StringBuilder();
        for (Medium child : arguments) {
            result.append(System.lineSeparator())
                    .append(child.print());
        }
        return result.toString();
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
