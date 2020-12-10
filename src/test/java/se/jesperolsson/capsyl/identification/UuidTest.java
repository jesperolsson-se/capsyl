/*
 * Capsyl is licenced under GPL-3.0. More info is found in ${basedir}/LICENCE.
 */
package se.jesperolsson.capsyl.identification;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;

/**
 * Tests for {@link Uuid}.
 *
 * @since 0.1
 */
@RunWith(JUnitQuickcheck.class)
public class UuidTest {

    /**
     * Given two different instances,
     * When the objects are asked to print themselves,
     * Then their output should differ.
     * @param first An UUID instance.
     * @param second Another UUID instance.
     */
    @Property public void produceUniqueIdentifiers(
        @From(UuidGenerator.class) final Uuid first,
        @From(UuidGenerator.class) final Uuid second) {
        MatcherAssert.assertThat(
            first.print(),
            CoreMatchers.not(CoreMatchers.equalTo(second.print()))
        );
    }

    /**
     * UUID generator, for property-based testing.
     *
     * @since 0.1
     */
    public static final class UuidGenerator extends Generator<Uuid> {

        /**
         * Constructs a UUID generator.
         */
        public UuidGenerator() {
            super(Uuid.class);
        }

        @Override
        public Uuid generate(
            final SourceOfRandomness seed,
            final GenerationStatus status) {
            return new Uuid();
        }
    }
}
