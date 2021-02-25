/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
 * Abstracts the textual representation of an encapsulatee.
 *
 * @since 0.1
 */
public interface Medium {

    /**
     * Asks the medium to add a depth to its representation.
     * @param depth The depth to represent.
     * @return A copy of the medium, that also contains the depth.
     */
    Medium withDepth(Depth depth);

    /**
     * Asks the medium to add a child to its representation.
     * @param encapsulatee A child encapsulation.
     * @return A copy of the medium, that also contains the child.
     */
    Medium representChild(Encapsulatee encapsulatee);

    /**
     * Asks the medium to add a name to its representation.
     * @param name The name.
     * @return A copy of the medium, that also contains the name.
     */
    Medium representName(String name);

    /**
     * Asks the medium to provide its representation as text.
     * @return A textual representation of an encapsulation.
     */
    String print();
}
