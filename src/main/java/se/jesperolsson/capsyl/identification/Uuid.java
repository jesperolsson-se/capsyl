/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.identification;

import java.util.UUID;

/**
 * Encapsulates the logic for a universally unique identifier (UUID).
 *
 * @since 0.1
 */
public final class Uuid implements Identity {

    /**
     * Java's UUID implementation.
     *
     * We discourage clients to use that class because of testability concerns.
     */
    private final UUID id;

    /**
     * Constructs a random UUID.
     */
    public Uuid() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String print() {
        return this.id.toString();
    }
}
