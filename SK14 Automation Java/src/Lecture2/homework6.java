package Lecture2;

public class homework6 {
    public static void main(String[] args) {
        double a = 1.0;
        double b = -3.0;
        double c = 2.0;

        double discriminant = b * b - 4 * a * c;

        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        System.out.println("Root 1: " + root1);
        System.out.println("Root 2: " + root2);
    }
}

