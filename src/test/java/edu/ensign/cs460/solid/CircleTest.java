package edu.ensign.cs460.solid;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.oc.Circle;

public class CircleTest {
    @Test
    public void area_happyPath_shouldReturnArea() {
        // arrange
        Circle circle = new Circle(5);
        // act
        double actArea = circle.area();
        // assert
        assert actArea == 78.53981633974483;
    }
}
