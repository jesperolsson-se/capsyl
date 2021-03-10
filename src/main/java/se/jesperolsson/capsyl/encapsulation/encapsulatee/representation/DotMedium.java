/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.SimpleEncapsulatees;
import se.jesperolsson.capsyl.identification.Uuid;

/**
 * Realizes the graphviz representation of an encapsulatee as a simple tree.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class DotMedium implements Medium {

    /**
     * The name to represent.
     */
    private final String name;

    /**
     * The subobjects to represent.
     */
    private final Encapsulatees children;

    /**
     * Constructs a default DotMedium.
     */
    public DotMedium() {
        this("");
    }

    /**
     * Constructs a DotMedium that can represent a name.
     *
     * @param name The preferred name of the encapsulatee.
     */
    public DotMedium(final String name) {
        this(name, new SimpleEncapsulatees());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     *
     * @param name The preferred name of the encapsulatee.
     * @param children The objects that are encapsulated.
     */
    public DotMedium(final String name, final Encapsulatees children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public Medium withDepth(final Depth depth) {
        return this;
    }

    @Override
    public Medium representChildren(final Encapsulatees encapsulatees) {
        return new DotMedium(this.name, encapsulatees);
    }

    @Override
    public Medium representName(final String preference) {
        return new DotMedium(preference, this.children);
    }

    @Override
    public String print() {
        final String result;
        if (this.children.isEmpty()) {
            result = new StringBuilder()
                .append('"')
                .append(new Uuid().print())
                .append('"')
                .append("[label=\"")
                .append(this.name)
                .append("\"]")
                .toString();
        } else {
            result = this.printCluster();
        }
        return result;
    }

    /**
     * Asks the medium to print itself as a subgraph (cluster).
     * @return A cluster representation of the DOT medium.
     */
    private String printCluster() {
        return new StringBuilder()
            .append("subgraph \"cluster ")
            .append(new Uuid().print())
            .append("\" { ")
            .append(this.printFamily())
            .append(" ")
            .append("}")
            .toString();
    }

    /**
     * Asks the medium to print itself and its children.
     * @return A string containing the medium and its children.
     */
    private String printFamily() {
        final StringBuilder family = new StringBuilder();
        family
            .append("label=\"")
            .append(this.name)
            .append('\"')
            .append(this.children.represent(new DotEncapsulatees()).print());
        return family.toString();
    }
}
