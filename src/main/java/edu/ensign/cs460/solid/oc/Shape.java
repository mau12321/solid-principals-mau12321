package edu.ensign.cs460.solid.oc;

// what modifier might you use to ensure this class can contain
// methods that are not implemented?
public class Shape {

    // the name implementation is the same for all shapes
    public final String getName() {
        throw new UnsupportedOperationException("getName() not implemented");
    };

    // the area calculation is different for each shape
    // and cannot be meaningfully implemented in the base class
    public double area() {
        throw new UnsupportedOperationException("area() not implemented");
    }
}
