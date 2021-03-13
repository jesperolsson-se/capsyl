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
import se.jesperolsson.capsyl.depth.Depth;
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
     * The depth at which the collective should be represented.
     */
    private final Depth level;

    /**
     * Constructs an empty collective.
     *
     * @param level The depth at which the collective should be represented.
     */
    public TreeEncapsulatees(final Depth level) {
        this(level, Collections.EMPTY_LIST);
    }

    /**
     * Constructs a collective from the given encapsulatees.
     *
     * @param level The depth at which the collective should be represented.
     * @param members Objects that want to form a collective.
     */
    public TreeEncapsulatees(final Depth level, final Encapsulatee... members) {
        this(
            level,
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
     * @param level The depth at which the collective should be represented.
     * @param members A group of objects that want to form a collective.
     */
    public TreeEncapsulatees(final Depth level, final Collection<Encapsulatee> members) {
        this.level = level;
        this.members = members;
    }

    @Override
    public EncapsulateesMedium withMembers(final Collection<Encapsulatee> collective) {
        return new TreeEncapsulatees(this.level, collective);
    }

    @Override
    public String print() {
        final StringBuilder result = new StringBuilder();
        this.members.stream().forEach(
            member -> result
                .append(System.lineSeparator())
                .append(member.represent(new EncapsulateeTreeMedium("", this.level.next())).print())
        );
        return result.toString();
    }
}

