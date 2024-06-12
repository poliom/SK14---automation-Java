package Lecture2;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter side a size");
        float a = myObj.nextFloat();

        System.out.println("Enter side b size");
        float h = myObj.nextFloat();

        float area = (a * h) / 2;

        System.out.println("The area of the triangle is: " + area);
    }

}
