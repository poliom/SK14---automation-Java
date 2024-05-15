package Lecture2;

import java.util.Scanner;

// Demos
public class Main {
    // psvm is the shortcut for creating main method
    public static void main(String[] args) {
        // sout is the shortcut for creating the System.out.println();
        System.out.println("Hello World!");

        int something; // null
        something = 10;
        System.out.println(something);
        something = 1;
        System.out.println(something);

        byte myByteVariable = 1;
        // camelCase and PascalCase
        int myIntVariable = 13270000;
        long myLong = 10000000000L; // L is mandatory
        boolean hasFirstName = false;
        String myText = "1111";
        char gender = 'm';

        // Cast
        double myDoubleNum = 9.999;
        int myIntNum = (int) myDoubleNum;

        // Parse
        String myNumberInString = "123";
        int parsedString = Integer.parseInt(myNumberInString);
        System.out.println(parsedString);

        int num = 6;
        System.out.println(num--);
        System.out.println(num);

        int num1 = 2000000000;
        int num2 = 2000000000;
        long result = (long) num1 + (long) num2;
        System.out.println(result);

        // Important !!!
        // Scanner creation
        Scanner scanner = new Scanner(System.in);
        // Tell the user what to do
        System.out.println("Enter username: ");
        // Read string
        String username = scanner.nextLine();
        System.out.println("The username is: " + username);

        // Read next string without spaces
        // The next() method reads the next token of input until it encounters whitespace
        // (space, tab, or newline). It returns the token as a String.
        System.out.println("Enter few words to force error: ");
        String token = scanner.next();
        System.out.println(token);

        // Read integer
        System.out.print("Enter an integer: ");
        int numberFromInput = scanner.nextInt();
        System.out.println("You entered: " + numberFromInput);

        System.out.print("Enter a byte: ");
        byte myByteInput = scanner.nextByte();
        System.out.println("You entered: " + myByteInput);

        System.out.print("Enter a long: ");
        long longNum = scanner.nextLong();
        System.out.println("You entered: " + longNum);

        System.out.print("Enter a double: ");
        double doubleNum = scanner.nextDouble();
        System.out.println("You entered: " + doubleNum);

        System.out.print("Enter a float: ");
        float floatNum = scanner.nextFloat();
        System.out.println("You entered: " + floatNum);

        // Remember to close the Scanner
        scanner.close();
    }
}