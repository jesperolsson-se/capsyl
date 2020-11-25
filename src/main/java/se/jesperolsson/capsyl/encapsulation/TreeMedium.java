package se.jesperolsson.capsyl.encapsulation;

import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Realizes the textual representation of an encapsulation as a simple tree.
 */
public class TreeMedium implements Medium {

    private final Depth depth;
    private final Encapsulatee encapsulatee;
    private final List<Medium> children;

    public TreeMedium() {
        this(new SpaceIndentation());
    }

    public TreeMedium(Depth depth) {
        this(depth, new NullEncapsulatee());
    }

    public TreeMedium(Depth depth, Encapsulatee encapsulatee) {
        this(depth, encapsulatee, new ArrayList<>());
    }

    public TreeMedium(Depth depth, Encapsulatee encapsulatee, List<Medium> children) {
        this.depth = depth;
        this.encapsulatee = encapsulatee;
        this.children = children;
    }

    private List<Medium> copyChildren() {
        return new LinkedList<>(children);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium representParameter(Encapsulatee encapsulatee) {
        return new TreeMedium(depth, encapsulatee, copyChildren());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium nextLevel() {
        return new TreeMedium(depth.next(), encapsulatee, copyChildren());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Medium representChild(Medium medium) {
        List<Medium> newChildren = copyChildren();
        newChildren.add(medium);
        return new TreeMedium(depth, encapsulatee, newChildren);
    }

    /**
     * {@inheritDoc}
     * @return A simple tree representation of the encapsulated contents.
     */
    @Override
    public String print() {
        return depth.print()
                + encapsulatee.name()
                + printChildren();
    }

    /**
     * Asks each child to print themselves.
     * @return The textual representation of each child.
     */
    public String printChildren() {
        StringBuilder result = new StringBuilder();
        children.forEach(child -> result.append(System.lineSeparator())
                .append(child.print()));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeMedium that = (TreeMedium) o;
        return Objects.equals(depth, that.depth) &&
                Objects.equals(encapsulatee, that.encapsulatee) &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depth, encapsulatee, children);
    }
}
