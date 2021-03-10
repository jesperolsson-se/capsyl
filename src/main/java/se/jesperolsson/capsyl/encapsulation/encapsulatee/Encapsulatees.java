/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.EncapsulateesMedium;

/**
 * Abstracts a collective of encapsulatees.
 *
 * @since 0.1
 */
public interface Encapsulatees {

    /**
     * Asks the collective whether or not it has any members.
     * @return True if there are no members in the collective; false otherwise.
     */
    boolean isEmpty();

    /**
     * Asks the entity to represent itself in the given medium.
     * @param medium The medium in which to represent the entity.
     * @return A copy of the medium, also containing a representation of the entity.
     */
    EncapsulateesMedium represent(EncapsulateesMedium medium);
}
