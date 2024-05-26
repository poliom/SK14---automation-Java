package Lecture4.DaysOfTheWeekPrinter;

import java.util.Scanner;
public class DaysOfTheWeekPrinter {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number between 1 and 7");
        int userInput = scanner.nextInt();

        String daysOfTheWeek;

        switch (userInput) {
            case 1:
                daysOfTheWeek = " Monday";
                break;
            case 2:
                daysOfTheWeek = " Tuesday";
                break;
            case 3:
                daysOfTheWeek = " Wednesday";
                break;
            case 4:
                daysOfTheWeek = " Thursday";
                break;
            case 5:
                daysOfTheWeek = " Friday";
                break;
            case 6:
                daysOfTheWeek = " Sadurday";
                break;
            case 7:
                daysOfTheWeek = " Sunday";
                break;
            default:
                daysOfTheWeek = " Invalid number";
                break;
        }
        System.out.println("The" + userInput + "day of the week is" + daysOfTheWeek);
    }
}

