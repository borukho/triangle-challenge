package ru.oxothuk.triangle.descriptor;

import org.junit.Test;
import ru.oxothuk.triangle.model.Triangle;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TriangleDescriptorTest {

    @Test
    public void assertEquilateralTypeForEquilateralTriangle() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 3, 3));
        assertThat(type(triangle), is(equalTo("equilateral")));
    }

    private String type(Triangle triangle) {
        return new TriangleDescriptor(triangle).type();
    }

    @Test
    public void assertIsoscelesTypeForIsoscelesAndNotEquilateralTriangle() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 3, 2));
        assertThat(type(triangle), is(equalTo("isosceles")));
    }

    @Test
    public void assertScaleneTypeForScaleneTriangle() throws Exception {
        Triangle triangle = new Triangle(Arrays.asList(3, 4, 5));
        assertThat(type(triangle), is(equalTo("scalene")));
    }
}