/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import lombok.EqualsAndHashCode;
import se.jesperolsson.capsyl.encapsulation.representation.Medium;
import se.jesperolsson.capsyl.encapsulation.representation.TreeMedium;

/**
 * Realizes a factory that will produce media for the tree format.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class TreeFactory implements MediaFactory {

    @Override
    public Medium encapsulation() {
        return new TreeMedium();
    }
}
