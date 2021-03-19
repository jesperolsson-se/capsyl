/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */

/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
* Represents a encapsulatees collective.
*
* @since 0.1
*/
@EqualsAndHashCode
public final class TreeEncapsulatees implements EncapsulateesMedium {

    /**
     * The members of the collective.
     */
    private final Collection<Encapsulatee> members;

    /**
     * Constructs an empty collective.
     */
    public TreeEncapsulatees() {
        this(Collections.EMPTY_LIST);
    }

    /**
     * Constructs a collective from the given encapsulatees.
     *
     * @param members Objects that want to form a collective.
     */
    public TreeEncapsulatees(final Encapsulatee... members) {
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
     *
     * @param members A group of objects that want to form a collective.
     */
    public TreeEncapsulatees(final Collection<Encapsulatee> members) {
        this.members = members;
    }

    @Override
    public EncapsulateesMedium withMembers(final Collection<Encapsulatee> collective) {
        return new TreeEncapsulatees(collective);
    }

    @Override
    public String print() {
        final StringBuilder result = new StringBuilder();
        this.members.stream().forEach(
            member -> result
                .append(System.lineSeparator())
                .append(member.represent().print())
        );
        return result.toString();
    }
}

