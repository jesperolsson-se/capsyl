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
     * Asks the entity to represent itself in the given medium.
     * @param medium The medium in which to represent the entity.
     * @return A copy of the medium, also containing a representation of the entity.
     */
    Medium represent(Medium medium);
}
