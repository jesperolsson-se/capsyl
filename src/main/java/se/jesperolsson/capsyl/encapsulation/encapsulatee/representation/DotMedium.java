/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.LinkedList;
import java.util.List;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.depth.SpaceIndentation;
import se.jesperolsson.capsyl.identification.Identity;
import se.jesperolsson.capsyl.identification.Uuid;

/**
 * Realizes the graphviz representation of an encapsulatee as a simple tree.
 *
 * @since 0.1
 */
public final class DotMedium implements Medium {

    /**
     * The name to represent.
     */
    private final String name;

    /**
     * The depth to represent.
     */
    private final Depth depth;

    /**
     * The submedia to represent.
     */
    private final List<Medium> children;

    /**
     * An identifier for the (sub-)graph.
     */
    private final Identity id;

    /**
     * Constructs a default DotMedium.
     */
    public DotMedium() {
        this("");
    }

    /**
     * Constructs a DotMedium that can represent a name.
     * @param name The preferred name of the encapsulatee.
     */
    public DotMedium(final String name) {
        this(name, new SpaceIndentation());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     * @param name The preferred name of the encapsulatee.
     * @param depth The medium's depth in the hierarchy.
     */
    public DotMedium(final String name, final Depth depth) {
        this(name, depth, new LinkedList<>());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     * @param name The preferred name of the encapsulatee.
     * @param depth The medium's depth in the hierarchy.
     * @param children The medium's submedia.
     */
    public DotMedium(final String name, final Depth depth, final List<Medium> children) {
        this(name, depth, children, new Uuid());
    }

    /**
     * Constructs a DotMedium that can represent a name at the specified depth.
     * @param name The preferred name of the encapsulatee.
     * @param depth The medium's depth in the hierarchy.
     * @param children The medium's submedia.
     * @param id The (sub-)graph's identifier.
     */
    public DotMedium(final String name, final Depth depth, final List<Medium> children, final Identity id) {
        this.name = name;
        this.depth = depth;
        this.children = children;
        this.id = id;
    }

    @Override
    public Medium withDepth(final Depth depth) {
        return new DotMedium(this.name, depth, this.copyChildren());
    }

    @Override
    public Medium representChild(final Medium medium) {
        final List<Medium> copies = this.copyChildren();
        copies.add(medium);
        return new DotMedium(this.name, this.depth, copies);
    }

    @Override
    public Medium representName(final String name) {
        return new DotMedium(name, this.depth, this.copyChildren());
    }

    @Override
    public Medium nextLevel() {
        return new DotMedium("", this.depth.next());
    }

    @Override
    public String print() {
        final StringBuilder result = new StringBuilder();
        if (!children.isEmpty()) {
            result.append(this.depth.print())
                .append("subgraph \"cluster " + this.id.print() + "\" {");
            result.append(System.lineSeparator())
                .append(this.depth.next().print())
                .append("label=\"")
                .append(this.name)
                .append("\"");
            this.children.forEach(child -> result.append(System.lineSeparator()).append(child.print()));
            result.append(System.lineSeparator());
            result.append(this.depth.print() + "}");
        } else {
            result.append(this.depth.print())
                .append(this.name);
        }
        return result.toString();
    }

    /**
     * Convenience method for creating a copy of the subtrees.
     * @return A copy of the list of children.
     */
    private List<Medium> copyChildren() {
        return new LinkedList<>(this.children);
    }
}
