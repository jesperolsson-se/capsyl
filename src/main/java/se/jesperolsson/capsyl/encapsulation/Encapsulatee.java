package se.jesperolsson.capsyl.encapsulation;

/**
 * Abstracts an entity that can be encapsulated.
 */
public interface Encapsulatee {

    /**
     * Asks the entity what its name is.
     * @return The encapsulated entity's preferred name.
     */
    String name();
}
