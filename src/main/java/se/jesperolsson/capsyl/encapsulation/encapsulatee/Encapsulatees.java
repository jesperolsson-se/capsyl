/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.DotMedium;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.EncapsulateeTreeMedium;

/**
 * Represents a encapsulatees collective.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class Encapsulatees {

    /**
     * The members of the collective.
     */
    private final Collection<Encapsulatee> members;

    /**
     * Constructs an empty collective.
     */
    public Encapsulatees() {
        this(Collections.EMPTY_LIST);
    }

    /**
     * Constructs a collective from the given encapsulatees.
     * @param members Objects that want to form a collective.
     */
    public Encapsulatees(final Encapsulatee... members) {
        this(
            Arrays.stream(
                members
            ).collect(
                Collectors.toList()
            )
        );
    }

    /**
     * Constructs a collective from the given group.
     * @param members A group of objects that want to form a collective.
     */
    public Encapsulatees(final Collection<Encapsulatee> members) {
        this.members = members;
    }

    /**
     * Asks the collective whether or not it has any members.
     * @return True if there are no members in the collective; false otherwise.
     */
    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    /**
     * Asks the collective to print themselves in DOT format.
     * @return A DOT representation of all members in the collective.
     */
    public String dotPrint() {
        final StringBuilder result = new StringBuilder();
        this.members.stream().forEach(
            member -> result
                .append(' ')
                .append(member.represent(new DotMedium("")).print())
        );
        return result.toString();
    }

    /**
     * Asks the collective to print themselves in tree format.
     * @param level The depth at which the collective should be represented.
     * @return A tree representation of all members in the collective.
     */
    public String treePrint(final Depth level) {
        final StringBuilder result = new StringBuilder();
        this.members.stream().forEach(
            member -> result
                .append(System.lineSeparator())
                .append(member.represent(new EncapsulateeTreeMedium("", level.next())).print())
        );
        return result.toString();
    }
}
