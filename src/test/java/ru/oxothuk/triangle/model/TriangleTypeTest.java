package ru.oxothuk.triangle.model;

import org.junit.Test;
import ru.oxothuk.triangle.factory.DefaultShapeFactory;
import ru.oxothuk.triangle.factory.ShapeFactory;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static ru.oxothuk.triangle.factory.TriangleSpecifications.byEdges;

public class TriangleTypeTest {

    private ShapeFactory shapeFactory = new DefaultShapeFactory();

    @Test
    public void assertTriangleWithAllEqualEdgesLengthIsEquilateral() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isEquilateral(), is(true));
    }

    @Test
    public void assertTriangleWithNotAllEqualEdgesLengthIsNotEquilateral() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isEquilateral(), is(false));
    }

    @Test
    public void assertTriangleWithTwoEqualEdgesLengthIsIsosceles() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 2)));
        assertThat(triangle.isIsosceles(), is(true));
    }

    @Test
    public void assertTriangleWithAllThreeEdgesOfDifferentLengthIsNotIsosceles() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isIsosceles(), is(false));
    }

    @Test
    public void assertEquilateralTriangleIsIsosceles() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isIsosceles(), is(true));
    }

    @Test
    public void assertTriangleWithAllThreeEdgesOfDifferentLengthIsScalene() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 4, 5)));
        assertThat(triangle.isScalene(), is(true));
    }

    @Test
    public void assertEquilateralTriangleIsScalene() throws Exception {
        Triangle triangle = shapeFactory.createTriangle(byEdges(Arrays.asList(3, 3, 3)));
        assertThat(triangle.isScalene(), is(true));
    }

}
