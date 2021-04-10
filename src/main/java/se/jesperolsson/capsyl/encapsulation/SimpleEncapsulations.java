/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Represents an encapsulations collective.
 *
 * @since 0.1
 */
public final class SimpleEncapsulations implements Encapsulations {

    /**
     * The members of the collective.
     */
    private final Collection<Encapsulation> members;

    /**
     * Constructs a collective from a list.
     * @param members The members of the collective.
     */
    public SimpleEncapsulations(final Collection<Encapsulation> members) {
        this.members = members;
    }

    @Override
    public String asText() {
        return String.join(
            System.lineSeparator(),
            StreamSupport.stream(this.members.spliterator(), false)
                .map(encapsulation -> encapsulation.represent().print())
                .collect(Collectors.toList())
        );
    }
}
