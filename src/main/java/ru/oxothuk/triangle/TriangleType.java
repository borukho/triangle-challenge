package ru.oxothuk.triangle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(TriangleType.class);

    public static void main(String[] args) {
        try {
            List<Number> edgesLength = mapCommandLineArgumentsToNumbers(args);
            logger.info("trying to create triangle with edges: {}", edgesLength);
            Triangle triangle = createTriangleBySpecifiedEdgesLength(edgesLength);
            logger.info("created triangle: {}", triangle);
            logger.info("triangle type is: {}", triangleType(triangle));
        } catch (Exception e) {
            logger.error("error while defining triangle type", e);
            printHelp();
        }
    }

    private static List<Number> mapCommandLineArgumentsToNumbers(String[] args) {
        return Stream.of(args)
            .map(arg -> {
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
