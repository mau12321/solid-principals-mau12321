package edu.ensign.cs460.solid;

import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.is.MultiFunctionPrinter;

public class MultiFunctionPrinterTest {
    @Test
    public void printDocument_HappyPath_shouldContainPrintInfo() {
        // Arrange
        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();

        // Act
        String actual = multiFunctionPrinter.printDocument("Hello World");

        // Assert
        assert actual.toLowerCase().contains("print");
        assert actual.toLowerCase().contains("hello world");
    }

    @Test
    public void scanDocument_HappyPath_shouldContainScanInfo() {
        // Arrange
        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();

        // Act
        String actual = multiFunctionPrinter.scanDocument("Hello World");

        // Assert
        assert actual.toLowerCase().contains("scan");
        assert actual.toLowerCase().contains("hello world");
    }

    @Test
    public void faxDocument_HappyPath_shouldContainFaxInfo() {
        // Arrange
        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();

        // Act
        String actual = multiFunctionPrinter.faxDocument("Hello World");

        // Assert
        assert actual.toLowerCase().contains("fax");
        assert actual.toLowerCase().contains("hello world");
    }
}
