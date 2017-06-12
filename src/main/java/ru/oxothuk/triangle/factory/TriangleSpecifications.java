package ru.oxothuk.triangle.factory;

import java.util.List;

public class TriangleSpecifications {
    private List<Number> edges;

    public List<Number> getEdges() {
        return edges;
    }

    public static TriangleSpecifications byEdges(List<Number> edges) {
        if (edges == null) {
            throw new IllegalArgumentException("you must specify edges");
        }
        TriangleSpecifications specifications = new TriangleSpecifications();
        specifications.edges = edges;
        return specifications;
    }

}
