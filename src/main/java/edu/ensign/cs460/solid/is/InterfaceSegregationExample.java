package edu.ensign.cs460.solid.is;

public final class InterfaceSegregationExample {
    private InterfaceSegregationExample() {
    }
    public static void main(final String[] args) {
        BasicPrinter basicPrinter = new BasicPrinter();
        System.out.println(basicPrinter.printDocument("Hello World"));

        MultiFunctionPrinter multiFunctionPrinter = new MultiFunctionPrinter();
        System.out.println(multiFunctionPrinter.printDocument("Hello World"));
        System.out.println(multiFunctionPrinter.scanDocument("Hello World"));
        System.out.println(multiFunctionPrinter.faxDocument("Hello World"));
    }
}
