package se.jesperolsson.capsyl;

/**
 * Abstracts a level in a hierarchy.
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
