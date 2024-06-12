package Lecture2;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter side a size");
        float a = myObj.nextFloat();

        System.out.println("Enter side b size");
        float b = myObj.nextFloat();

        System.out.println("Enter side c size");
        float c = myObj.nextFloat();

        float perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

}
