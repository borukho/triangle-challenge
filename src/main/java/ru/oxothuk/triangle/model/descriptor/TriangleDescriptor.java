package ru.oxothuk.triangle.model.descriptor;

import ru.oxothuk.triangle.model.Triangle;

public class TriangleDescriptor {
    private Triangle triangle;

    public TriangleDescriptor(Triangle triangle) {
        this.triangle = triangle;
    }

    public String type() {
        if (triangle.isEquilateral()) return "equilateral";
        if (triangle.isIsosceles()) return "isosceles";
        return "scalene";
    }
}
