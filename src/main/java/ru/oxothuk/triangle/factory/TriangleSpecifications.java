package ru.oxothuk.triangle.factory;

import java.util.List;

public class TriangleSpecifications {
    private List<Integer> edges;

    public List<Integer> getEdges() {
        return edges;
    }

    public static TriangleSpecifications byEdges(List<Integer> edges) {
        TriangleSpecifications specifications = new TriangleSpecifications();
        specifications.edges = edges;
        return specifications;
    }

}
