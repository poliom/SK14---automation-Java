package Lecture2;

import java.util.Scanner;

public class homework5 {

    public static class InputExample {
        public static void main (String[] args) {
            String firstName = "Tsveta";
            String middleName = "Valentinova";
            String lastName = "Vasileva";

            Scanner scanner = new Scanner(System.in);

            System.out.print(firstName + " T " + middleName + " V " + lastName + " V ");
            int number = scanner.nextInt();

            int result = number * 2;

            System.out.println("The result is: " + result);

            scanner.close();
        }
    }
}
