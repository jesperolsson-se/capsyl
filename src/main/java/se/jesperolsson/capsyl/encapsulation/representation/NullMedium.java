/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import se.jesperolsson.capsyl.encapsulation.Encapsulatee;

/**
 * Null object for a medium.
 *
 * @since 0.1
 */
public final class NullMedium implements Medium {

    @Override
    public Medium representEncapsulatee(final Encapsulatee encapsulatee) {
        return new NullMedium();
    }

    @Override
    public Medium nextLevel() {
        return new NullMedium();
    }

    @Override
    public Medium representChild(final Medium medium) {
        return new NullMedium();
    }

    @Override
    public String print() {
        return "";
    }
}
