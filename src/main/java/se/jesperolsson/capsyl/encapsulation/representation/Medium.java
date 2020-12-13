/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
 * Abstracts the textual representation of an encapsulation.
 *
 * @since 0.1
 */
public interface Medium {

    /**
     * Asks the medium to add an encapsulatee to its representation.
     * @param encapsulatee A representation of an encapsulated object.
     * @return A copy of the medium, that also contains the encapsulatee.
     */
    Medium representEncapsulatee(Encapsulatee encapsulatee);

    /**
     * Asks the medium to provide a medium that can represent the next level
     * in the encapsulation hierarchy.
     * @return A medium, that represents a new encapsulation level.
     */
    Medium nextLevel();

    /**
     * Asks the medium to add a child to its representation.
     * @param medium A child encapsulation.
     * @return A copy of the medium, that also contains the child.
     */
    Medium representChild(Medium medium);

    /**
     * Asks the medium to provide its representation as text.
     * @return A textual representation of an encapsulation.
     */
    String print();
}
