/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Represents a collective of encapsulations.
 *
 * @since 0.1
 */
public final class Encapsulations {

    /**
     * The members of the collective.
     */
    private final List<Encapsulation> members;

    /**
     * Constructs a collective from a list.
     * @param members The members of the collective.
     */
    public Encapsulations(final List<Encapsulation> members) {
        this.members = members;
    }

    /**
     * Asks the encapsulations to provide a textual represent of itself.
     * @return The textual representation of the encapsulations.
     */
    public String asText() {
        final List<String> parts = StreamSupport.stream(this.members.spliterator(), false)
            .map(encapsulation -> encapsulation.represent().print())
            .collect(Collectors.toList());
        return String.join(System.lineSeparator(), parts);
    }
}
