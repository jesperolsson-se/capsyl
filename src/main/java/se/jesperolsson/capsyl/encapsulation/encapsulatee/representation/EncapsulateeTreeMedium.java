/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.LinkedList;
import java.util.List;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
 * Realizes the textual representation of an encapsulatee as a simple tree.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class EncapsulateeTreeMedium implements Medium {

    /**
     * The name to represent.
     */
    private final String name;

    /**
     * The depth to represent.
     */
    private final Depth depth;

    /**
     * The subtrees to represent.
     */
    private final List<Encapsulatee> children;

    /**
     * Constructs a default TreeMedium.
     */
    public EncapsulateeTreeMedium() {
        this("");
    }

    /**
     * Constructs a TreeMedium that can represent a name.
     * @param name The preferred name of the encapsulatee.
     */
    public EncapsulateeTreeMedium(final String name) {
        this(name, new SpaceIndentation());
    }

    /**
     * Constructs a TreeMedium that can represent a name at the specified depth.
     * @param name The preferred name of the encapsulatee.
     * @param depth The tree's depth in the hierarchy.
     */
    public EncapsulateeTreeMedium(final String name, final Depth depth) {
        this(name, depth, new LinkedList<>());
    }

    /**
     * Constructs a TreeMedium that can represent a name at the specified depth,
     * as well as subtrees.
     * @param name The preferred name of the encapsulatee.
     * @param depth The tree's depth in the hierarchy.
     * @param children The tree's subtrees.
     */
    public EncapsulateeTreeMedium(
        final String name,
        final Depth depth,
        final List<Encapsulatee> children) {
        this.name = name;
        this.depth = depth;
        this.children = children;
    }

    @Override
    public Medium withDepth(final Depth level) {
        return new EncapsulateeTreeMedium(this.name, level, this.copyChildren());
    }

    @Override
    public Medium representChild(final Encapsulatee encapsulatee) {
        final List<Encapsulatee> copies = this.copyChildren();
        copies.add(encapsulatee);
        return new EncapsulateeTreeMedium(this.name, this.depth, copies);
    }

    @Override
    public Medium representName(final String preference) {
        return new EncapsulateeTreeMedium(preference, this.depth, this.copyChildren());
    }

    @Override
    public String print() {
        return this.depth.print() + this.name + this.printChildren();
    }

    /**
     * Asks each child to print themselves.
     * @return The textual representation of each child.
     */
    public String printChildren() {
        final StringBuilder result = new StringBuilder();
        this.children.forEach(
            child -> result.append(System.lineSeparator())
                .append(child.represent(this.nextLevel())
                    .print()
                )
        );
        return result.toString();
    }

    /**
     * Convenience method for creating a copy of the subtrees.
     * @return A copy of the list of children.
     */
    private List<Encapsulatee> copyChildren() {
        return new LinkedList<>(this.children);
    }

    /**
     * Creates a medium on the next level in the hierarchy.
     * @return A new medium with an incremented depth.
     */
    private Medium nextLevel() {
        return new EncapsulateeTreeMedium("", this.depth.next());
    }
}
