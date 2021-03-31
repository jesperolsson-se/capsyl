/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

/**
 * Abstracts a means to refer to an entity.
 *
 * @since 0.1
 */
public interface Name {

    /**
     * Asks the object to represent itself as text.
     * @return A textual of the name.
     */
    String print();
}
