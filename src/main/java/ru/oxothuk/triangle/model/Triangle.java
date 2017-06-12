package ru.oxothuk.triangle.model;

import ru.oxothuk.triangle.factory.TriangleValidator;
import ru.oxothuk.triangle.factory.ValidationException;

import java.util.List;

public class Triangle {
    private List<Number> edges;

    public List<Number> getEdges() {
        return edges;
    }

    public Triangle(List<Number> edges) {
        this.edges = edges;
        validate();
    }

    private void validate() {
        try {
            new TriangleValidator().validate(this);
        } catch (ValidationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public boolean isEquilateral() {
        return edges.stream().distinct().count() == 1;
    }

    public boolean isIsosceles() {
        long count = edges.stream().distinct().count();
        return count == 2 || count == 1;
    }

    public boolean isScalene() {
        return true;
    }
}
