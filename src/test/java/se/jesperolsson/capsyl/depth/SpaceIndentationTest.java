package se.jesperolsson.capsyl.depth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SpaceIndentationTest {

    /**
     * Given two objects with the same depth, but different width,
     * When the objects are asked to print themselves,
     * Then the results should differ.
     */
    @Test
    public void interpretWidth() {
        int depth = 1;
        int width = 1;
        assertNotEquals(
                new SpaceIndentation(depth, width).print(),
                new SpaceIndentation(depth, width + 1).print());
    }

    /**
     * Given two objects with the same width, but different depth,
     * When the objects are asked to print themselves,
     * Then the results should differ.
     */
    @Test
    public void interpretDepth() {
        int width = 1;
        int depth = 1;
        assertNotEquals(
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
        int width = 1;
        int depth = 1;
        assertEquals(
                new SpaceIndentation(depth + 1, width),
                new SpaceIndentation(depth, width).next()
        );
    }
}