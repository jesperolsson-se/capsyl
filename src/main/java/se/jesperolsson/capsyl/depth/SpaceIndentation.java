package se.jesperolsson.capsyl.depth;

import java.util.Objects;

/**
 * Realizes depth through use of space indentation.
 */
public class SpaceIndentation implements Depth {

    private final int depth;
    private final int width;

    /**
     * Constructs a space indentation starting at level zero.
     */
    public SpaceIndentation() {
        this(0);
    }

    /**
     * Constructs a space indentation starting at the specified level.
     * @param depth The level in the hierarchy to represent.
     */
    public SpaceIndentation(int depth) {
        this(depth, 2);
    }

    /**
     * Constructs a space indentation with the specified width, starting at the specified level.
     * @param depth The level in the hierarchy to represent.
     * @param width The number of spaces used to different one level from the next.
     */
    public SpaceIndentation(int depth, int width) {
        this.depth = depth;
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Depth next() {
        return new SpaceIndentation(depth + 1, width);
    }

    /**
     * {@inheritDoc}
     * @return A space indentation equal to depth * width.
     */
    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceIndentation that = (SpaceIndentation) o;
        return depth == that.depth &&
                width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(depth, width);
    }
}
