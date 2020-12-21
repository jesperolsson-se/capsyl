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
 * Realizes the textual representation of an encapsulation in DOT language.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class DotMedium implements Medium {

    /**
     * The medium's location in the hierarchy.
     */
    private final Depth depth;

    /**
     * The object that is encapsulated.
     */
    private final Encapsulatee encapsulatee;

    /**
     * Flag that indicates if this medium is the root node.
     */
    private final boolean root;
    private final String name;

    /**
     * Constructs a default DotMedium.
     */
    public DotMedium() {
        this(new SpaceIndentation());
    }

    /**
     * Constructs a DotMedium at the specified depth.
     * @param depth The medium's depth in the hierarchy.
     */
    public DotMedium(final Depth depth) {
        this(depth, new NullEncapsulatee());
    }

    /**
     * Constructs a DotMedium that can represent an encapsulation at the specified depth.
     * @param depth The medium's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     */
    public DotMedium(final Depth depth, final Encapsulatee encapsulatee) {
        this(depth, encapsulatee, true);
    }

    /**
     * Constructs a DotMedium that can represent an encapsulation at the specified depth.
     * @param depth The medium's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     * @param root Flag indicating whether this is the root medium.
     */
    private DotMedium(
        final Depth depth,
        final Encapsulatee encapsulatee,
        final boolean root) {
        this(depth, encapsulatee, root, "Var");
    }

    /**
     * Constructs a DotMedium that can represent an encapsulation at the specified depth.
     * @param depth The medium's depth in the hierarchy.
     * @param encapsulatee The object that is encapsulated.
     * @param root Flag indicating whether this is the root medium.
     * @param name The name of the medium.
     */
    private DotMedium(
        final Depth depth,
        final Encapsulatee encapsulatee,
        final boolean root,
        final String name) {
        this.depth = depth;
        this.encapsulatee = encapsulatee;
        this.root = root;
        this.name = name;
    }

    @Override
    public Medium representEncapsulatee(final Encapsulatee subject) {
        return new DotMedium(this.depth, subject, this.root, this.name);
    }

    @Override
    public Medium representName(final String name) {
        return new DotMedium(this.depth, this.encapsulatee, this.root, name);
    }

    @Override
    public String print() {
        // I probably need to know if I'm root or not.
        final StringBuilder result = new StringBuilder();
        result.append(this.depth.print())
            .append("graph {")
            .append(System.lineSeparator());
        result.append(this.depth.next().print())
            .append("label=\"")
            .append(this.name)
            .append("\"")
            .append(System.lineSeparator());
        result.append(this.encapsulatee.represent(
            new se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotMedium()
                .withDepth(this.depth.next())
        ).print());
        result.append(System.lineSeparator());
        result.append(this.depth.print());
        result.append("}");
        return result.toString();
    }
}
