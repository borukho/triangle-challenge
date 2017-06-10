package ru.oxothuk.triangle.factory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.oxothuk.triangle.model.Triangle;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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
        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(2, 3, 4));
        Triangle triangle = factory.createTriangle(specifications);

        assertThat(triangle, is(notNullValue()));
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenTriangleDoesNotMatchTriangleRule() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("Triangle with such edges can not exist"))
        ));

        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(10, 3, 4));
        factory.createTriangle(specifications);
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenLessThanThreeEdgesSpecified() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("You should specify all three edges length"))
        ));

        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(10, 2));
        factory.createTriangle(specifications);
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenMoreThanThreeEdgesSpecified() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("You should specify all three edges length"))
        ));

        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(10, 2, 3, 4));
        factory.createTriangle(specifications);
    }

    @Test
    public void assertIllegalArgumentExceptionThrown_whenEdgeLengthIsNotPositive() throws Exception {
        exception.expect(allOf(
            is(instanceOf(IllegalArgumentException.class)),
            hasProperty("message", equalTo("Triangle edges length must be positive"))
        ));

        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(-2, 3, 4));
        factory.createTriangle(specifications);
    }

    @Test
    public void assertCreatedTriangleHasSaveEdgesLengthAsSpecification() throws Exception {
        TriangleSpecifications specifications = TriangleSpecifications.byEdges(Arrays.asList(3, 4, 5));
        Triangle triangle = factory.createTriangle(specifications);

        assertThat(triangle.getEdges(), contains(3, 4, 5));
    }
}
