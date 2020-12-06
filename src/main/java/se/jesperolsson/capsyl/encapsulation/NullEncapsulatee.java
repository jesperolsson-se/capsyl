/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import java.util.Collections;
import java.util.List;
import lombok.EqualsAndHashCode;

/**
 * Null object for an encapsulatee.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class NullEncapsulatee implements Encapsulatee {

    @Override
    public String name() {
        return "";
    }

    @Override
    public List<Encapsulatee> children() {
        return Collections.emptyList();
    }
}
