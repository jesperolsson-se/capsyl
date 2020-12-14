/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import lombok.EqualsAndHashCode;

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
     * Constructs a default TreeMedium.
     */
    public TreeMedium() {
        this("");
    }

    /**
     * Constructs a TreeMedium that can represent a name.
     * @param name The preferred name of the encapsulatee
     */
    public TreeMedium(final String name) {
        this.name = name;
    }

    @Override
    public Medium representName(final String preference) {
        return new TreeMedium(preference);
    }

    @Override
    public String print() {
        return this.name;
    }
}
