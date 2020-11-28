/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

/**
 * Abstracts a level in a hierarchy.
 *
 * @since 0.1
 */
public interface Depth {

    /**
     * Asks the depth to reveal the next level in the hierarchy.
     * @return The next level in the hierarchy.
     */
    Depth next();

    /**
     * Asks the depth to represent itself as text.
     * @return A textual of the hierarchy level.
     */
    String print();
}
