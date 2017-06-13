package ru.oxothuk.triangle.factory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.oxothuk.triangle.model.Triangle;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static ru.oxothuk.triangle.factory.TriangleSpecifications.*;

public class DefaultShapeFactory_testCreateTriangle {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private DefaultShapeFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new DefaultShapeFactory();
    }

    @Test
    public void assertTriangleIsCreatedByThreeEdgesLength() throws Exception {
        Triangle triangle = factory.createTriangle(byEdges(Arrays.asList(2, 3, 4)));

        assertThat(triangle, is(notNullValue()));
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenTriangleDoesNotMatchTriangleRule() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("Triangle with such edges can not exist"))
        ));

        factory.createTriangle(byEdges(Arrays.asList(10, 3, 4)));
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenLessThanThreeEdgesSpecified() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("You should specify all three edges length"))
        ));

        factory.createTriangle(byEdges(Arrays.asList(10, 2)));
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenMoreThanThreeEdgesSpecified() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("You should specify all three edges length"))
        ));

        factory.createTriangle(byEdges(Arrays.asList(10, 2, 3, 4)));
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenEdgeLengthIsNotPositive() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("Triangle edges length must be positive"))
        ));

        factory.createTriangle(byEdges(Arrays.asList(-2, 3, 4)));
    }

    @Test
    public void assertCreatedTriangleHasSaveEdgesLengthAsSpecification() throws Exception {
        Triangle triangle = factory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));

        assertThat(triangle.getEdges(), contains(3, 4, 5));
    }

    @Test
    public void assertIllegalArgumentExceptionForNullEdgeLength() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("Triangle edges must be not null"))
        ));

        factory.createTriangle(byEdges(Arrays.asList(null, 4, 5)));
    }
}
