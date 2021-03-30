/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatees;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.NullEncapsulatees;
import se.jesperolsson.capsyl.identification.Identity;
import se.jesperolsson.capsyl.identification.Uuid;
import se.jesperolsson.capsyl.name.Name;
import se.jesperolsson.capsyl.name.NullName;
import se.jesperolsson.capsyl.name.QuotationEscapedName;

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
        this(new Uuid());
    }

    /**
     * Constructs a DotMedium with a specific identity.
     *
     * @param id The identifier of the encapsulatee.
     */
    public DotMedium(final Identity id) {
        this(id, new NullName(), new NullEncapsulatees());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     *
     * @param id The identifier of the encapsulatee.
     * @param name The preferred name of the encapsulatee.
     *  May not contain unescaped quotation marks.
     * @param children The objects that are encapsulated.
     */
    public DotMedium(final Identity id, final Name name, final Encapsulatees children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    @Override
    public Medium withDepth(final Depth depth) {
        return this;
    }

    @Override
    public Medium representChildren(final Encapsulatees encapsulatees) {
        return new DotMedium(this.id, this.name, encapsulatees);
    }

    @Override
    public Medium representName(final Name preference) {
        return new DotMedium(this.id, new QuotationEscapedName(preference), this.children);
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
                .append(this.name.print())
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
