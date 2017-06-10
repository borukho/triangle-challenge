package ru.oxothuk.triangle;

import ru.oxothuk.triangle.descriptor.TriangleDescriptor;
import ru.oxothuk.triangle.factory.DefaultShapeFactory;
import ru.oxothuk.triangle.factory.ShapeFactory;
import ru.oxothuk.triangle.model.Triangle;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.oxothuk.triangle.factory.TriangleSpecifications.byEdges;

public class Starter {
    public static void main(String[] args) {
        List<Integer> edgesLength = Stream.of(args)
            .map(arg -> {
                if (!arg.matches("[+-]\\d+")) {
                    throw new IllegalArgumentException("Triangle edges must be a integer");
                }
                return Integer.parseInt(arg);
            })
            .collect(Collectors.toList());

        ShapeFactory shapeFactory = new DefaultShapeFactory();
        Triangle triangle = shapeFactory.createTriangle(byEdges(edgesLength));

        String triangleType = new TriangleDescriptor(triangle).type();
        System.out.println(String.format("This is %s triangle", triangleType));
    }
}