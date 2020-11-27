/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.encapsulation.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.NullEncapsulatee;

/**
 * Realizes the textual representation of an encapsulation as a simple tree.
 *
 * @since 0.1
 */
public final class TreeMedium implements Medium {

    /**
     * The tree's location in the hierarchy.
     */
    private final Depth depth;

    /**
     * The object that is encapsulated.
     */
    private final Encapsulatee encapsulatee;

    /**
     * List of subtrees.
     */
    private final List<Medium> children;

    /**
     * Constructs a default TreeMedium.
     */
    public TreeMedium() {
        this(new SpaceIndentation());
    }

    /**
     * Constructs a TreeMedium at the specified depth.
     * @param depth The tree's depth in the hierarchy.
     */
    public TreeMedium(final Depth depth) {
        this(depth, new NullEncapsulatee());
    }

    /**
     * Constructs a TreeMedium that can represent an encapsulation at the specified depth.
     * @param depth The tree's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     */
    public TreeMedium(final Depth depth, final Encapsulatee encapsulatee) {
        this(depth, encapsulatee, new LinkedList<>());
    }

    /**
     * Constructs a TreeMedium that can represent an encapsulation at the specified depth,
     * as well as subtrees.
     * @param depth The tree's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     * @param children The subtrees.
     */
    public TreeMedium(
        final Depth depth,
        final Encapsulatee encapsulatee,
        final List<Medium> children) {
        this.depth = depth;
        this.encapsulatee = encapsulatee;
        this.children = children;
    }

    @Override
    public Medium representEncapsulatee(final Encapsulatee subject) {
        return new TreeMedium(this.depth, subject, this.copyChildren());
    }

    @Override
    public Medium nextLevel() {
        return new TreeMedium(this.depth.next(), this.encapsulatee, this.copyChildren());
    }

    @Override
    public Medium representChild(final Medium medium) {
        final List<Medium> copies = this.copyChildren();
        copies.add(medium);
        return new TreeMedium(this.depth, this.encapsulatee, copies);
    }

    @Override
    public String print() {
        return this.depth.print()
            + this.encapsulatee.name()
            + this.printChildren();
    }

    /**
     * Asks each child to print themselves.
     * @return The textual representation of each child.
     */
    public String printChildren() {
        final StringBuilder result = new StringBuilder();
        this.children.forEach(child -> result.append(System.lineSeparator()).append(child.print()));
        return result.toString();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TreeMedium that = (TreeMedium) obj;
        return Objects.equals(this.depth, that.depth)
            && Objects.equals(this.encapsulatee, that.encapsulatee)
            && Objects.equals(this.children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.depth, this.encapsulatee, this.children);
    }

    /**
     * Convenience method for creating a copy of the subtrees.
     * @return A copy of the list of children.
     */
    private List<Medium> copyChildren() {
        return new LinkedList<>(this.children);
    }
}
