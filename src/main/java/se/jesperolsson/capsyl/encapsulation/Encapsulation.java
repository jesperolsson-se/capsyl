/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Abstracts an encapsulation. That is, something that is being encapsulated plus metadata.
 *
 * @since 0.1
 */
public interface Encapsulation {

    /**
     * Asks the object to represent itself.
     * @return A medium containing a representation of the encapsulation.
     */
    Medium represent();
}
