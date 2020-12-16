/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;

/**
 * Realizes the textual representation of an encapsulatee as a simple tree.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class TreeMedium implements Medium {

    /**
     * The name to represent.
     */
    private final String name;

    /**
     * The depth to represent.
     */
    private final Depth depth;

    /**
     * Constructs a default TreeMedium.
     */
    public TreeMedium() {
        this("");
    }

    /**
     * Constructs a TreeMedium that can represent a name.
     * @param name The preferred name of the encapsulatee.
     */
    public TreeMedium(final String name) {
        this(name, new SpaceIndentation());
    }

    /**
     * Constructs a TreeMedium that can represent a name, at the specified depth.
     * @param name The preferred name of the encapsulatee.
     * @param depth The tree's depth in the hierarchy.
     */
    public TreeMedium(final String name, final Depth depth) {
        this.name = name;
        this.depth = depth;
    }

    @Override
    public Medium withDepth(final Depth level) {
        return new TreeMedium(this.name, level);
    }

    @Override
    public Medium representName(final String preference) {
        return new TreeMedium(preference, this.depth);
    }

    @Override
    public String print() {
        return this.depth.print() + this.name;
    }
}
