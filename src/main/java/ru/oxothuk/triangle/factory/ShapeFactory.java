package ru.oxothuk.triangle.factory;

import ru.oxothuk.triangle.model.Triangle;

public interface ShapeFactory {
    Triangle createTriangle(TriangleSpecifications specifications);
}
