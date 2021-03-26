/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.name;

/**
 * Represents a name that consists of only one part.
 *
 * @since 0.1
 */
public final class Mononym implements Name {

    /**
     * The text that constitutes the name.
     */
    private final String name;

    /**
     * Constructs a mononymous entity.
     *
     * @param name The text that addresses the entity.
     */
    public Mononym(final String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return this.name;
    }
}
