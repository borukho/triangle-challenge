package ru.oxothuk.triangle.model;

import ru.oxothuk.triangle.model.validation.TriangleValidator;
import ru.oxothuk.triangle.model.validation.ValidationException;

import java.util.Collections;
import java.util.List;

public class Triangle {
    private final List<Number> edges;

    public List<Number> getEdges() {
        return edges;
    }

    public Triangle(List<Number> edges) {
        this.edges = Collections.unmodifiableList(edges);
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
        long count = edges.stream().distinct().count();
        return count == 3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
            "edges=" + edges +
            '}';
    }
}
