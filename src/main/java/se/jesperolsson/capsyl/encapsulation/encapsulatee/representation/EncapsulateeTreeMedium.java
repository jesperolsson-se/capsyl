/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.encapsulation.NullFactory;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.SimpleEncapsulatees;

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
    private final Encapsulatees children;

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
        this(name, depth, new SimpleEncapsulatees(new NullFactory()));
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
        final Encapsulatees children) {
        this.name = name;
        this.depth = depth;
        this.children = children;
    }

    @Override
    public Medium withDepth(final Depth level) {
        return new EncapsulateeTreeMedium(this.name, level, this.children);
    }

    @Override
    public Medium representChildren(final Encapsulatees encapsulatees) {
        return new EncapsulateeTreeMedium(this.name, this.depth, encapsulatees);
    }

    @Override
    public Medium representName(final String preference) {
        return new EncapsulateeTreeMedium(preference, this.depth, this.children);
    }

    @Override
    public String print() {
        return this.depth.print() + this.name + this.children.represent().print();
    }
}
