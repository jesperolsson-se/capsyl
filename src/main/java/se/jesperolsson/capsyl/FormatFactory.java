/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import se.jesperolsson.capsyl.encapsulation.representation.Medium;

/**
 * Abstracts the creational decision of media.
 *
 * @since 0.1
 */
public interface FormatFactory {

    /**
     * Asks the object to create a medium.
     *
     * @return An instance of a medium.
     */
    Medium create();
}
