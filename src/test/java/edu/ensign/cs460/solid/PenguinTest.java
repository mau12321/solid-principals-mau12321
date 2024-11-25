package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.ls.AfricanSwallow;
import edu.ensign.cs460.solid.ls.Penguin;

public class PenguinTest {
    @Test
    public void swim_happyPath_shouldContainSwim() {
        // arrange
        Penguin penguin = new Penguin("Penguin", "Black and White");
        // act
        String actSwim = penguin.swim();
        // assert
        assertTrue(actSwim.contains("swim"), "swim");
    }

    @Test
    public void penguin_class_shouldNotHaveLayEggMethod() {
        // arrange
        Class<?> penguinClass = Penguin.class;
        Method[] methods = penguinClass.getDeclaredMethods();
        boolean layEgg = false;
        for (Method method : methods) {
            if (method.getName().equals("layEgg")) {
                // assert
                layEgg = true;
            }
        }
        assertTrue(!layEgg, "Penguin class should not have layEgg method");
    }

    @Test
    public void penguin_class_shouldNotHaveFlyMethod() {
        // arrange
        Class<?> penguinClass = Penguin.class;
        Method[] methods = penguinClass.getDeclaredMethods();
        boolean flyExists = false;
        for (Method method : methods) {
            if (method.getName().equals("fly")) {
                // assert
                flyExists = true;
            }
        }
        assertTrue(!flyExists, "Penguin class should not have fly method");
    }

    @Test
    public void penguin_class_shouldHaveSwimMethod() {
        // arrange
        Class<?> penguinClass = AfricanSwallow.class;
        Method[] methods = penguinClass.getDeclaredMethods();
        boolean swimExists = false;
        for (Method method : methods) {
            if (method.getName().equals("carryCoconut")) {
                // assert
                swimExists = true;
            }
        }
        assertTrue(swimExists, "Penguin class should have swim method");
    }

}
