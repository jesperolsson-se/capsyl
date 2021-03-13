/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.EncapsulateesMedium;

/**
 * Represents a encapsulatees collective.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class SimpleEncapsulatees implements Encapsulatees {

    /**
     * The members of the collective.
     */
    private final Collection<Encapsulatee> members;

    /**
     * Constructs an empty collective.
     */
    public SimpleEncapsulatees() {
        this(Collections.EMPTY_LIST);
    }

    /**
     * Constructs a collective from the given encapsulatees.
     * @param members Objects that want to form a collective.
     */
    public SimpleEncapsulatees(final Encapsulatee... members) {
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
    public SimpleEncapsulatees(final Collection<Encapsulatee> members) {
        this.members = members;
    }

    @Override
    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    @Override
    public EncapsulateesMedium represent(final EncapsulateesMedium medium) {
        return medium.withMembers(this.members);
    }
}
