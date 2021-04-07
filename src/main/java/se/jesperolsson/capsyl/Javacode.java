/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import se.jesperolsson.capsyl.encapsulation.Encapsulations;

/**
 * Abstracts a snippet of Java source code.
 *
 * @since 0.1
 */
public interface Javacode {

    /**
     * Returns a collective of encapsulations present in the code.
     * @return Encapsulations that can be found in the Java source code snippet.
     */
    Encapsulations encapsulations();
}
