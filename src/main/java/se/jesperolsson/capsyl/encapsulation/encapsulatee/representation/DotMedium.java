/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.NullFactory;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.SimpleEncapsulatees;
import se.jesperolsson.capsyl.identification.Identity;
import se.jesperolsson.capsyl.identification.Uuid;
import se.jesperolsson.capsyl.name.Name;
import se.jesperolsson.capsyl.name.NullName;

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
    private final Name name;

    /**
     * The subobjects to represent.
     */
    private final Encapsulatees children;

    /**
     * The entity's identifier.
     */
    @EqualsAndHashCode.Exclude
    private final Identity id;

    /**
     * Constructs a default DotMedium.
     */
    public DotMedium() {
        this(new NullName());
    }

    /**
     * Constructs a DotMedium that can represent a name.
     *
     * @param name The preferred name of the encapsulatee.
     */
    public DotMedium(final Name name) {
        this(name, new SimpleEncapsulatees(new NullFactory()));
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     *
     * @param name The preferred name of the encapsulatee.
     * @param children The objects that are encapsulated.
     */
    public DotMedium(final Name name, final Encapsulatees children) {
        this(name, children, new Uuid());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     *
     * @param name The preferred name of the encapsulatee.
     * @param children The objects that are encapsulated.
     * @param id The identifier of the encapsulatee.
     */
    public DotMedium(final Name name, final Encapsulatees children, final Identity id) {
        this.name = name;
        this.children = children;
        this.id = id;
    }

    @Override
    public Medium withDepth(final Depth depth) {
        return this;
    }

    @Override
    public Medium representChildren(final Encapsulatees encapsulatees) {
        return new DotMedium(this.name, encapsulatees, this.id);
    }

    @Override
    public Medium representName(final Name preference) {
        return new DotMedium(preference, this.children, this.id);
    }

    @Override
    public String print() {
        final StringBuilder result;
        if (this.children.isEmpty()) {
            result = new StringBuilder()
                .append('"')
                .append(this.id.print())
                .append('"')
                .append("[label=\"")
                .append(this.name.print().replace("\"", "\\\""))
                .append("\"]");
        } else {
            result = new StringBuilder()
                .append("subgraph \"cluster ")
                .append(this.id.print())
                .append("\" { ")
                .append("label=\"")
                .append(this.name.print())
                .append('\"')
                .append(' ')
                .append(this.children.represent().print())
                .append(' ')
                .append("}");
        }
        return result.toString();
    }
}
