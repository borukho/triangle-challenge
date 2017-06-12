package ru.oxothuk.triangle.factory;

import ru.oxothuk.triangle.model.Triangle;

import java.util.List;

public class TriangleValidator {
    public void validate(Triangle triangle) throws ValidationException {
        List<Integer> edges = triangle.getEdges();
        if (edges.size() != 3) {
            throw new ValidationException("You should specify all three edges length");
        }
        for (Integer edge : edges) {
            if (edge <= 0) throw new ValidationException("Triangle edges length must be positive");
            int twoOtherEdgesLengthSum = edges.stream()
                .mapToInt(Integer::intValue)
                .sum() - edge;
            if (edge >= twoOtherEdgesLengthSum) {
                throw new ValidationException("Triangle with such edges can not exist");
            }
        }
    }
}
