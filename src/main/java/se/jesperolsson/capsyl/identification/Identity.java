/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.identification;

/**
 * Abstracts a means of identification.
 *
 * @since 0.1
 */
public interface Identity {

    /**
     * Asks the object to represent itself as text.
     * @return A textual of the identifier.
     */
    String print();
}
