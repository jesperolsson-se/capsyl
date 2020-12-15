/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import java.util.LinkedList;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.encapsulation.encapsulatee.JpLiteral;

/**
 * Tests for {@link JpLiteral}.
 *
 * @since 0.1
 */
public class JpLiteralTest {

    /**
     * Given a literal,
     * When the object is asked for its children,
     * Then it should return a null object (since literals can't encapsulate).
     */
    @Test
    public void reportAbsenceOfChildren() {
        MatcherAssert.assertThat(
            new LinkedList<>(),
            CoreMatchers.equalTo(new JpLiteral(null).children())
        );
    }
}
