package ru.oxothuk.triangle;

import ru.oxothuk.triangle.model.descriptor.TriangleDescriptor;
import ru.oxothuk.triangle.factory.DefaultShapeFactory;
import ru.oxothuk.triangle.factory.ShapeFactory;
import ru.oxothuk.triangle.model.Triangle;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.oxothuk.triangle.factory.TriangleSpecifications.byEdges;

public class Starter {
    public static void main(String[] args) {
        List<Number> edgesLength = Stream.of(args)
            .map(arg -> {
                if (!arg.matches("[+-]\\d+(\\.\\d*)?")) {
                    throw new IllegalArgumentException("Triangle edges must be a number");
                }
                try {
                    return NumberFormat.getInstance().parse(arg);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Triangle edges must be a number", e);
                }
            })
            .collect(Collectors.toList());

        ShapeFactory shapeFactory = new DefaultShapeFactory();
        Triangle triangle = shapeFactory.createTriangle(byEdges(edgesLength));

        String triangleType = new TriangleDescriptor(triangle).type();
        System.out.println(String.format("This is %s triangle", triangleType));
    }
}
