/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

/**
 * Abstracts a collective of encapsulations.
 *
 * @since 0.1
 */
public interface Encapsulations {

    /**
     * Asks the encapsulations to provide a textual represent of itself.
     * @return The textual representation of the encapsulations.
     */
    String asText();
}
