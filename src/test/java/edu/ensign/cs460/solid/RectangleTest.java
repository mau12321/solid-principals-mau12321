package edu.ensign.cs460.solid;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.oc.Rectangle;

public class RectangleTest {
    @Test
    public void area_happyPath_shouldReturnArea() {
        // arrange
        Rectangle rectangle = new Rectangle(4, 6);
        // act
        double actArea = rectangle.area();
        // assert
        assert actArea == 24;
    }

}
