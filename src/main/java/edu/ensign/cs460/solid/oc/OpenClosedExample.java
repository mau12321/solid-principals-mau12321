package edu.ensign.cs460.solid.oc;

import java.util.ArrayList;
import java.util.List;

public final class OpenClosedExample {
    private OpenClosedExample() {
    }
    public static void main(final String[] args) {
        //CHECKSTYLE:OFF
        int radius = 5;
        int width = 4;
        int height = 6;
        //CHECKSTYLE:ON
        List<Shape> shapes = new ArrayList<Shape>() {{
            add(new Circle(radius));   // Circle with radius 5
            add(new Rectangle(width, height)); // Rectangle with width 4 and height 6
        }};

        TotalAreaCalculator calculator = new TotalAreaCalculator();
        String totalArea = calculator.calculateTotalArea(shapes);
        System.out.println(totalArea);
    }
}
