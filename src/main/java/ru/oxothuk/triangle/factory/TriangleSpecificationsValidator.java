package ru.oxothuk.triangle.factory;

import java.util.List;

public class TriangleSpecificationsValidator {
    public void validate(TriangleSpecifications specifications) throws ValidationException {
        List<Integer> edges = specifications.getEdges();
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
