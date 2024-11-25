package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.oc.Shape;
import edu.ensign.cs460.solid.oc.Circle;
import edu.ensign.cs460.solid.oc.Rectangle;
import edu.ensign.cs460.solid.oc.TotalAreaCalculator;

public class TotalAreaCalculatorTest {
    private TotalAreaCalculator totalAreaCalculator;
    private List<Shape> shapes;

    @BeforeEach
    public void setUp() {
        totalAreaCalculator = new TotalAreaCalculator();
        shapes = new ArrayList<Shape>(){{
            add(new Circle(5));   // Circle with radius 5
            add(new Rectangle(4, 6)); // Rectangle with width 4 and height 6
        }};
    }

    @Test
    public void calculateTotalArea_happyPath_shouldReturnAreas() {
        // arrange
        double expTotalArea = 5 * 5 * Math.PI + 4 * 6;
        // act
        String actTotalAreaReport = totalAreaCalculator.calculateTotalArea(shapes);
        // assert
        assertTrue(actTotalAreaReport.contains(String.valueOf(expTotalArea)));
        assertTrue(actTotalAreaReport.contains(String.valueOf(shapes.get(0).area()))); 
        assertTrue(actTotalAreaReport.contains(String.valueOf(shapes.get(1).area())));
    }

    @Test
    public void calculateTotalArea_happyPath_shouldReturnNames() {
        // act
        String actTotalAreaReport = totalAreaCalculator.calculateTotalArea(shapes);
        // assert
        assertTrue(actTotalAreaReport.contains(shapes.get(0).getName()));
        assertTrue(actTotalAreaReport.contains(shapes.get(1).getName()));
    }
}
