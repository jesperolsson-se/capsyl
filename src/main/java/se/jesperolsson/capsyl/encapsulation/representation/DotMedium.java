/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import lombok.EqualsAndHashCode;
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
     * The object that is encapsulated.
     */
    private final Encapsulatee encapsulatee;

    /**
     * The name of the encapsulation.
     */
    private final String name;

    /**
     * Constructs a default DotMedium.
     */
    public DotMedium() {
        this(new NullEncapsulatee());
    }

    /**
     * Constructs a DotMedium that can represent an encapsulation at the specified depth.
     * @param encapsulatee The object that is encapsulated.
     */
    public DotMedium(final Encapsulatee encapsulatee) {
        this(encapsulatee, "Var");
    }

    /**
     * Constructs a DotMedium that can represent an encapsulation at the specified depth.
     * @param encapsulatee The object that is encapsulated.
     * @param name The name of the medium.
     */
    public DotMedium(final Encapsulatee encapsulatee, final String name) {
        this.encapsulatee = encapsulatee;
        this.name = name;
    }

    @Override
    public Medium representEncapsulatee(final Encapsulatee subject) {
        return new DotMedium(subject, this.name);
    }

    @Override
    public Medium representName(final String preference) {
        return new DotMedium(this.encapsulatee, preference);
    }

    @Override
    public String print() {
        return new StringBuilder()
            .append("graph { ")
            .append("label=\"")
            .append(this.name)
            .append("\" ")
            .append(
                this.encapsulatee.represent(
                    new se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotMedium()
                ).print()
            ).append(" }")
            .toString();
    }
}
