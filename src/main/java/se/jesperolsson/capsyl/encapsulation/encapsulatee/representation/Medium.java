/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee.representation;

/**
 * Abstracts the textual representation of an encapsulatee.
 *
 * @since 0.1
 */
public interface Medium {

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
