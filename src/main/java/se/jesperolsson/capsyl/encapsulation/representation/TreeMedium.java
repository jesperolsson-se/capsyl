/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatee;

/**
 * Realizes the textual representation of an encapsulation as a simple tree.
 *
 * @since 0.1
 */
@EqualsAndHashCode
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
     * Constructs a TreeMedium that can represent an encapsulation at the specified depth,
     * as well as subtrees.
     * @param depth The tree's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     */
    public TreeMedium(
        final Depth depth,
        final Encapsulatee encapsulatee) {
        this.depth = depth;
        this.encapsulatee = encapsulatee;
    }

    @Override
    public Medium representEncapsulatee(final Encapsulatee subject) {
        return new TreeMedium(this.depth, subject);
    }

    @Override
    // Trees exclude names.
    public Medium representName(final String name) {
        return new TreeMedium(this.depth, this.encapsulatee);
    }

    @Override
    public String print() {
        return this.encapsulatee.represent().print();
    }
}
