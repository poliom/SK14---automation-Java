package Lecture4.TriangleCalculator;

import java.util.Scanner;

public class TriangleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the three angles of the triangle:");
        int angle1 = scanner.nextInt();
        int angle2 = scanner.nextInt();
        int angle3 = scanner.nextInt();

        if (angle1 + angle2 + angle3 == 180) {
            System.out.println("The triangle can be built based on the angle values.");

            if (angle1 == 60 && angle2 == 60 && angle3 == 60) {
                System.out.println("Type: Equilateral Triangle");
            } else if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
                System.out.println("Type: Right Angled Triangle");
            } else if (angle1 > 90 || angle2 > 90 || angle3 > 90) {
                System.out.println("Type: Obtuse Triangle");
            } else if (angle1 < 90 && angle2 < 90 && angle3 < 90) {
                System.out.println("Type: Acute Triangle");
            }
        } else {
            System.out.println("The triangle can't be built based on the angle values.");
        }
    }
}