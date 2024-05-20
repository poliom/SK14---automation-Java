package Lecture2;

public class homework4 {
    // Print the area of a triangle by given sides. Use formula to calculate it.
    public static void main(String[] args) {

        double sideA = 8.0;
        double sideB = 10.0;
        double sideC = 10.0;
        double semiPerimeter = (sideA + sideB + sideC) / 2;

        double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
        System.out.println("The area of the triangle is: " + area);
    }
}