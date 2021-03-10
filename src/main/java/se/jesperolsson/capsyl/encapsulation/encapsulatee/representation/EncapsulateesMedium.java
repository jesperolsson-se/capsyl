/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

import java.util.Collection;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.Encapsulatee;

/**
 * Abstracts the textual representation of a collective of encapsulatees.
 *
 * @since 0.1
 */
public interface EncapsulateesMedium {

    /**
     * Asks the medium to add a collective of encapsulatees to its representation.
     * @param collective The encapsulatees to represent.
     * @return A copy of the medium, that also contains the collective.
     */
    EncapsulateesMedium withMembers(Collection<Encapsulatee> collective);

    /**
     * Asks the collective to represent themselves in a textual format.
     * @return A string representation of known members in the collective.
     */
    String print();
}
