/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a encapsulatees collective.
 *
 * @since 0.1
 */
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
     * A stream of the members of the collective.
     * @return The members of the collective.
     * @deprecated Ideally, this will be a temporary seam.
     */
    @Deprecated
    public Stream<Encapsulatee> stream() {
        return this.members.stream();
    }
}
