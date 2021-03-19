/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import se.jesperolsson.capsyl.encapsulation.MediaFactory;

/**
 * Abstracts the creational decision of output format.
 *
 * @since 0.1
 */
public interface FormatFactory {

    /**
     * Asks the object to create a media factory.
     *
     * @return An instance of a media factory.
     */
    MediaFactory create();
}
