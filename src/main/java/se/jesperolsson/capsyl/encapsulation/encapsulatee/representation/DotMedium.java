/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.LinkedList;
import java.util.List;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;
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
     * The submedia to represent.
     */
    private final List<Encapsulatee> children;

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
        this(name, new LinkedList<>());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     *
     * @param name The preferred name of the encapsulatee.
     * @param children The medium's submedia.
     */
    public DotMedium(final String name, final List<Encapsulatee> children) {
        this.name = name;
        this.children = children;
    }

    @Override
    public Medium withDepth(final Depth depth) {
        return this;
    }

    @Override
    public Medium representChild(final Encapsulatee encapsulatee) {
        final List<Encapsulatee> copies = this.copyChildren();
        copies.add(encapsulatee);
        return new DotMedium(this.name, copies);
    }

    @Override
    public Medium representName(final String preference) {
        return new DotMedium(preference, this.copyChildren());
    }

    @Override
    public String print() {
        final String result;
        if (this.children.isEmpty()) {
            result = this.name;
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
        family.append("label=\"")
            .append(this.name)
            .append('\"');
        this.children.forEach(
            child -> family
                .append(' ')
                .append(child.represent(new DotMedium("")).print())
        );
        return family.toString();
    }

    /**
     * Convenience method for creating a copy of the subtrees.
     * @return A copy of the list of children.
     */
    private List<Encapsulatee> copyChildren() {
        return new LinkedList<>(this.children);
    }
}
