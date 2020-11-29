/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link SpaceIndentation}.
 *
 * @since 0.1
 */
public class SpaceIndentationTest {

    /**
     * Given two objects with the same depth, but different width,
     * When the objects are asked to print themselves,
     * Then the results should differ.
     */
    @Test
    public void interpretWidth() {
        final int depth = 1;
        final int width = 1;
        Assert.assertNotEquals(
            new SpaceIndentation(depth, width).print(),
            new SpaceIndentation(depth, width + 1).print()
        );
    }

    /**
     * Given two objects with the same width, but different depth,
     * When the objects are asked to print themselves,
     * Then the results should differ.
     */
    @Test
    public void interpretDepth() {
        final int width = 1;
        final int depth = 1;
        Assert.assertNotEquals(
            new SpaceIndentation(depth, width).print(),
            new SpaceIndentation(depth + 1, width).print()
        );
    }

    /**
     * When the object is asked to give the next depth,
     * Then the result should equal an object with one higher depth.
     */
    @Test
    public void incrementDepth() {
        final int width = 1;
        final int depth = 1;
        Assert.assertEquals(
            new SpaceIndentation(depth + 1, width),
            new SpaceIndentation(depth, width).next()
        );
    }
}
