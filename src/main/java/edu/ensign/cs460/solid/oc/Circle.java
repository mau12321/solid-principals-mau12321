package edu.ensign.cs460.solid.oc;

public final class Circle extends Shape {
    public Circle(final double radius) {
        throw new UnsupportedOperationException("Circle constructor not implemented");
    }

    // the correct funtion is Math.PI * radius * radius
    @Override
    public double area() {
        throw new UnsupportedOperationException("area() not implemented");
    }
}
