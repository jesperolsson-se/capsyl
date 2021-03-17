/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Abstract factory for creating media.
 *
 * @since 0.1
 */
public interface MediaFactory {

    /**
     * Asks the object to create a medium for an encapsulation.
     *
     * @return A medium in which an encapsulation can represent itself.
     */
    Medium encapsulation();

    /**
     * Asks the object to create a medium for an encapsulatee.
     *
     * @return A medium in which an encapsulatee can represent itself.
     */
    se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium encapsulatee();
}
