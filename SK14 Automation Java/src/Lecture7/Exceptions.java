package Lecture7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            double result = divideNumbers(num1, num2);
            System.out.println("The division result is: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }

    public static double divideNumbers(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }

        return (double) num1 / num2;
    }
}
