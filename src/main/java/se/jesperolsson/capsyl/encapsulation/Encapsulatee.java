/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.util.List;

/**
 * Abstracts an entity that can be encapsulated.
 *
 * @since 0.1
 */
public interface Encapsulatee {

    /**
     * Asks the entity what its name is.
     * @return The encapsulated entity's preferred name.
     */
    String name();

    /**
     * Asks the entity what children it has.
     * @return Encapsulatable children to this entity.
     */
    List<Encapsulatee> children();
}
