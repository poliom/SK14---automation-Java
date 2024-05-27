package Lecture6.Examples;

import java.util.Scanner;

public class AgeValidation {
    public static void main(String[] args){
        System.out.println("This is program for validate user age");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the user age: ");
        int age = input.nextInt();
        Examples.checkAge(age);
    }
}
