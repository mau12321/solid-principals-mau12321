package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.oc.Shape;

public class ShapeTest {
    @Test
    public void ShapeClass_area_shouldBeAbstract() {
        // arrange
        Class<?> shapeClass = Shape.class;
        Method[] methods = shapeClass.getDeclaredMethods();
        boolean areaMethodIsAbstract = false;
        for (Method method : methods) {
            if (method.getName().equals("area")) {
                // assert
                areaMethodIsAbstract = Modifier.isAbstract(method.getModifiers());
            }
        }
        // assert
        assertTrue(areaMethodIsAbstract, "Shape.area() method is not abstract");
    }



}
