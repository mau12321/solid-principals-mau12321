package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.ls.AfricanSwallow;

public class AfricanSwallowTest {
    @Test
    public void carryCoconut_happyPath_shouldReturnCoconut() {
        // arrange
        AfricanSwallow swallow = new AfricanSwallow("African Swallow", "Blue");
        // act
        String actCarryCoconut = swallow.carryCoconut();
        // assert
        assertTrue(actCarryCoconut.contains("coconut"), "coconut");
    }

    @Test
    public void fly_happyPath_shouldContainFly() {
        // arrange
        AfricanSwallow swallow = new AfricanSwallow("African Swallow", "Blue");
        // act
        String actFly = swallow.fly();
        // assert
        assertTrue(actFly.contains("fly"), "fly");
    }
    
    @Test
    public void swallow_class_shouldHaveCarryCoconutMethod() {
        // arrange
        Class<?> swallowClass = AfricanSwallow.class;
        Method[] methods = swallowClass.getDeclaredMethods();
        boolean carryCoconutMethodExists = false;
        for (Method method : methods) {
            if (method.getName().equals("carryCoconut")) {
                // assert
                carryCoconutMethodExists = true;
            }
        }

        // assert
        assertTrue(carryCoconutMethodExists, "swallow class should have carryCoconut method");
    }

    @Test
    public void swallow_class_shouldHaveFlyMethod() {
        // arrange
        Class<?> swallowClass = AfricanSwallow.class;
        Method[] methods = swallowClass.getDeclaredMethods();
        boolean fly = false;
        for (Method method : methods) {
            if (method.getName().equals("fly")) {
                // assert
                fly = true;
            }
        }

        // assert
        assertTrue(fly, "swallow class should have fly method");
    }

    @Test
    public void swallow_class_shouldNotHaveLayEggMethod() {
        // arrange
        Class<?> swallowClass = AfricanSwallow.class;
        Method[] methods = swallowClass.getDeclaredMethods();
        boolean layEgg = false;
        for (Method method : methods) {
            if (method.getName().equals("layEgg")) {
                // assert
                layEgg = true;
            }
        }

        // assert
        assertTrue(!layEgg, "Swallow class should not have layEgg method");
    }

}
