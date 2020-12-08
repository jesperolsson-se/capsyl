/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.depth;

import java.util.Optional;
import java.util.stream.IntStream;
import lombok.EqualsAndHashCode;

/**
 * Realizes depth through use of space indentation.
 *
 * @since 0.1
 */
@EqualsAndHashCode
public final class SpaceIndentation implements Depth {

    /**
     * The number of levels between this instance and the top level of the hierarchy.
     */
    private final int depth;

    /**
     * The number of spaces to indent with, per level.
     */
    private final int width;

    /**
     * Constructs a space indentation starting at the top of the hierarchy.
     */
    public SpaceIndentation() {
        this(0);
    }

    /**
     * Constructs a space indentation starting at the specified level.
     * @param depth The level in the hierarchy to represent.
     */
    public SpaceIndentation(final int depth) {
        this(depth, 2);
    }

    /**
     * Constructs a space indentation with the specified width, starting at the specified level.
     * @param depth The level in the hierarchy to represent.
     * @param width The number of spaces used to different one level from the next.
     */
    public SpaceIndentation(final int depth, final int width) {
        this.depth = depth;
        this.width = width;
    }

    @Override
    public Depth next() {
        return new SpaceIndentation(this.depth + 1, this.width);
    }

    @Override
    public String print() {
        final StringBuilder result = new StringBuilder();
        final Optional<String> spaces = IntStream
            .range(0, this.width)
            .mapToObj(i -> " ")
            .reduce(String::concat);
        IntStream
            .range(0, this.depth)
            .mapToObj(i -> spaces.get()).forEach(s -> result.append(s));
        return result.toString();
    }
}
