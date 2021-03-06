/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * System tests.
 *
 * @since 0.1
 */
public class MainTest {

    /**
     * Given that Capsyl is constructed with the example file and a tree configuration,
     * When the program is asked to execute,
     * Then it should output the encapsulations as a simple tree.
     * @throws FileNotFoundException Should never occur.
     */
    @Test
    public void outputSimpleTree() throws IOException {
        final Main sut = new Main("src/main/java/se/jesperolsson/capsyl/App.txt", "tree");
        MatcherAssert.assertThat(
            new StringBuilder()
            .append("Apa")
            .append(System.lineSeparator())
            .append("  Apa")
            .append(System.lineSeparator())
            .append("    Bepa")
            .append(System.lineSeparator())
            .append("      3")
            .append(System.lineSeparator())
            .append("    2")
            .append(System.lineSeparator())
            .append("  1")
            .append(System.lineSeparator())
            .append("Cepa")
            .append(System.lineSeparator())
            .append("  Depa")
            .append(System.lineSeparator())
            .append("  Epa")
            .toString(),
            CoreMatchers.equalTo(sut.execute())
        );
    }
}
