package ru.oxothuk.triangle.model;

import java.util.List;

public class Triangle {
    private List<Integer> edges;

    public List<Integer> getEdges() {
        return edges;
    }

    public Triangle(List<Integer> edges) {
        this.edges = edges;
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
