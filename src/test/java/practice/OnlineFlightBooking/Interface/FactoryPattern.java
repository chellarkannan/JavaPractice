package practice.OnlineFlightBooking.Interface;

// --- (Assumed) Product Interface/Abstract Class ---
// (This part is not shown in the image but is necessary for the factory)
interface Shape {
    void draw();
 }
 
 // --- (Assumed) Concrete Products ---
 // (These classes are not shown in the image but are necessary)
 class Circle implements Shape {
    @Override
    public void draw() {
       System.out.println("Drawing a circle...");
    }
 }
 
 class Square implements Shape {
    @Override
    public void draw() {
       // This println might belong here based on the stray line in the image
       System.out.println("Drawing a square...");
    }
 }
 
 // --- Factory Class ---
 // Creates objects without exposing the instantiation logic to the client.
 class ShapeFactory {
 
     // Static factory method
     // Returns an object of type Shape based on the input string.
     // Note: The return type 'Shape' and classes 'Circle', 'Square' are inferred
     // as they were cut off in the image.
     public static Shape getShape(String type) { // Made public for accessibility
         if (type == null) {
             return null;
         }
         if (type.equalsIgnoreCase("CIRCLE")) {
             return new Circle();
         } else if (type.equalsIgnoreCase("SQUARE")) {
             return new Square();
         }
         // Potentially other shapes or a default case / exception handling needed here
         return null; // Or throw an exception for unknown type
     }
     // The closing brace '}' for the class was likely cut off in the image.
 }
 
 
 
 // --- Example Usage (How you might use the factory) ---

public class FactoryPattern {

    public static void main(String[] args) {
        // Get an object of Circle and call its draw method.
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        if (shape1 != null) shape1.draw(); // Output: Drawing a circle...

        // Get an object of Square and call its draw method.
        Shape shape2 = ShapeFactory.getShape("SQUARE");
        if (shape2 != null) shape2.draw(); // Output: Drawing a square...
    }
}
