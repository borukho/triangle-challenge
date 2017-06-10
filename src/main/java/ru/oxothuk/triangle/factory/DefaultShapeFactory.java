package ru.oxothuk.triangle.factory;

import ru.oxothuk.triangle.model.Triangle;

public class DefaultShapeFactory implements ShapeFactory {
    @Override
    public Triangle createTriangle(TriangleSpecifications specifications) {
        validate(specifications);
        return new Triangle(specifications.getEdges());
    }

    private void validate(TriangleSpecifications specifications) {
        try {
            new TriangleSpecificationsValidator().validate(specifications);
        } catch (ValidationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
