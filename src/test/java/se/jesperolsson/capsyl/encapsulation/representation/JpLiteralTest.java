/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation.representation;

import com.github.javaparser.ast.expr.LiteralExpr;
import java.util.LinkedList;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.mockito.Mockito;
import se.jesperolsson.capsyl.encapsulation.JpLiteral;

/**
 * Tests for {@link JpLiteral}.
 *
 * @since 0.1
 */
public class JpLiteralTest {

    /**
     * Given a literal,
     * When the object is asked to say its name,
     * Then it should respond with the literal's value.
     */
    @Test
    // We have to use verify, because the method is final (and thus can't be mocked properly).
    public void sayItsName() {
        final LiteralExpr literal = Mockito.mock(LiteralExpr.class);
        new JpLiteral(literal).name();
        Mockito.verify(literal).toString();
    }

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
