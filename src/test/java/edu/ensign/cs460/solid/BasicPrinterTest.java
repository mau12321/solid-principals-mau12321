package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.is.BasicPrinter;

public class BasicPrinterTest {
    @Test
    public void printDocument_HappyPath_shouldContainPrintInfo() {
        // Arrange
        BasicPrinter basicPrinter = new BasicPrinter();

        // Act
        String actual = basicPrinter.printDocument("Hello World");

        // Assert
        assert actual.toLowerCase().contains("print");
        assert actual.toLowerCase().contains("hello world");
    }

    @Test
    public void basicPrinter_class_shouldNotHave_faxDocument_method() {
        // Arrange
        Class<?> basicPrinterClass = BasicPrinter.class;
        Method[] methods = basicPrinterClass.getDeclaredMethods();
        boolean faxDocumentExists = false;
        for (Method method : methods) {
            if (method.getName().equals("faxDocument")) {
                // assert
                faxDocumentExists = true;
            }
        }

        // assert
        assertTrue(!faxDocumentExists, "BasicPrinter class should not have faxDocument method");
    }

    @Test
    public void basicPrinter_class_shouldNotHave_scanDocument_method() {
        // Arrange
        Class<?> basicPrinterClass = BasicPrinter.class;
        Method[] methods = basicPrinterClass.getDeclaredMethods();
        boolean scanDocumentExists = false;
        for (Method method : methods) {
            if (method.getName().equals("scanDocument")) {
                // assert
                scanDocumentExists = true;
            }
        }

        // assert
        assertTrue(!scanDocumentExists, "BasicPrinter class should not have scanDocument method");
    }

}
