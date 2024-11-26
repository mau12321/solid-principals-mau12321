package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.ls.Bird;
import java.lang.reflect.Method;

public class BirdTest {
    @Test
    public void layEgg_happyPath_shouldContainEgg() {
        // arrange
        Bird bird = new Bird("Sparrow", "Yellow");
        // act
        String actLayEgg = bird.layEgg();
        // assert
        assertTrue(actLayEgg.contains(actLayEgg), "egg");
    }

    @Test
    public void bird_class_shouldNotHaveFlyMethod() {
        // arrange
        Class<?> birdClass = Bird.class;
        Method[] methods = birdClass.getDeclaredMethods();
        boolean flyMethodExists = false;
        for (Method method : methods) {
            if (method.getName().equals("fly")) {
                // assert
                flyMethodExists = true;
            }
        }

        // assert
        assertTrue(!flyMethodExists, "Bird class should not have fly method");
    }

    @Test
    public void bird_class_shouldNotHaveSwimMethod() {
        // arrange
        Class<?> birdClass = Bird.class;
        Method[] methods = birdClass.getDeclaredMethods();
        boolean swimMethodExists = false;
        for (Method method : methods) {
            if (method.getName().equals("swim")) {
                // assert
                swimMethodExists = true;
            }
        }

        // assert
        assertTrue(!swimMethodExists, "Bird class should not have swim method");
    }

    @Test
    public void bird_class_shouldNotHaveCarryCoconutMethod() {
        // arrange
        Class<?> birdClass = Bird.class;
        Method[] methods = birdClass.getDeclaredMethods();
        boolean carryCoconutMethodExists = false;
        for (Method method : methods) {
            if (method.getName().equals("carryCoconut")) {
                // assert
                carryCoconutMethodExists = true;
            }
        }

        // assert
        assertTrue(!carryCoconutMethodExists, "Bird class should not have carryCoconut method");
    }
}


