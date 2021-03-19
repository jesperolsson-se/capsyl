/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;

/**
 * Abstracts an entity that can be encapsulated.
 *
 * @since 0.1
 */
public interface Encapsulatee {

    /**
     * Asks the encapsulatee to represent itself.
     * @return A medium containing a representation of the encapsulatee.
     */
    Medium represent();
}
