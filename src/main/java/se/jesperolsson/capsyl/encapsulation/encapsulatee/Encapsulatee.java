/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.List;
import se.jesperolsson.capsyl.depth.Depth;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;

/**
 * Abstracts an entity that can be encapsulated.
 *
 * @since 0.1
 */
public interface Encapsulatee {

    /**
     * Asks the entity to represent itself.
     * @param depth The depth at which the representation should occur.
     * @return A medium containing  a representation of the entity.
     */
    Medium represent(Depth depth);

    /**
     * Asks the entity what children it has.
     * @return Encapsulatable children to this entity.
     */
    List<Encapsulatee> children();
}
