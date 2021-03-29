/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import se.jesperolsson.capsyl.name.Mononym;

/**
 * Tests for {@link Encapsulation}.
 *
 * @since 0.1
 */
public class EncapsulationTest {

    /**
     * Given that no name is provided,
     * When the object constructed,
     * Then the object should be named "Var".
     */
    @Test
    public void suggestDefaultName() {
        MatcherAssert.assertThat(
            new Encapsulation(
                new ObjectCreationExpr(),
                new NullFactory()
            ),
            CoreMatchers.equalTo(
                new Encapsulation(
                    new ObjectCreationExpr(),
                    new NullFactory(),
                    new Mononym("Var")
                )
            )
        );
    }
}
