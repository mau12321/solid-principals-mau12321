package edu.ensign.cs460.solid.oc;

public final class Rectangle extends Shape {
    public Rectangle(final double width, final double height) {
        throw new UnsupportedOperationException("Rectangle constructor not implemented");
    }

    // the correct function is width * height
    @Override
    public double area() {
        throw new UnsupportedOperationException("area() not implemented");
    }
}
