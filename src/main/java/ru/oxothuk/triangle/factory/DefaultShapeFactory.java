package ru.oxothuk.triangle.factory;

import ru.oxothuk.triangle.model.Triangle;

public class DefaultShapeFactory implements ShapeFactory {
    @Override
    public Triangle createTriangle(TriangleSpecifications specifications) {
        return new Triangle(specifications.getEdges());
    }
}
