/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.encapsulatee;

import java.util.List;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.representation.Medium;

/**
 * Abstracts an entity that can be encapsulated.
 *
 * @since 0.1
 */
public interface Encapsulatee {

    Medium represent();

    /**
     * Asks the entity what children it has.
     * @return Encapsulatable children to this entity.
     */
    List<Encapsulatee> children();
}
