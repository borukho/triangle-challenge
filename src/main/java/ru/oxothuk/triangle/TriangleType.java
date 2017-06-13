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

public class TriangleType {
    public static void main(String[] args) {
        try {
            List<Number> edgesLength = mapCommandLineArgumentsToNumbers(args);
            Triangle triangle = createTriangleBySpecifiedEdgesLength(edgesLength);
            System.out.println(String.format("This is %s triangle", triangleType(triangle)));
        } catch (Exception e) {
            System.out.println("error while defining triangle type: " + e.getMessage());
            printHelp();
        }
    }

    private static List<Number> mapCommandLineArgumentsToNumbers(String[] args) {
        return Stream.of(args)
            .map(arg -> {
                if (!arg.matches("[+-]?\\d+(\\.\\d+)?")) {
                    throw new IllegalArgumentException("Triangle edge length must be a number: " + arg);
                }
                try {
                    return NumberFormat.getInstance().parse(arg);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Triangle edge length must be a number: " + arg, e);
                }
            })
            .collect(Collectors.toList());
    }

    private static Triangle createTriangleBySpecifiedEdgesLength(List<Number> edgesLength) {
        ShapeFactory shapeFactory = new DefaultShapeFactory();
        return shapeFactory.createTriangle(byEdges(edgesLength));
    }

    private static String triangleType(Triangle triangle) {
        return new TriangleDescriptor(triangle).type();
    }

    private static void printHelp() {
        System.out.println("command syntax: java " + TriangleType.class.getName() +
            " <all three triangle edges length>");
    }
}
