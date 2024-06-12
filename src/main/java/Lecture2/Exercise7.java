package Lecture2;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        byte minutesInHour = 60;
        byte hoursInDay = 24;
        short daysInYear = 365;
        int minutesInYear = minutesInHour * hoursInDay * daysInYear;

        Scanner input = new Scanner(System.in);

        System.out.print("Input the number of minutes: ");

        long min = input.nextLong();

        long years = (min / minutesInYear);
        long days = (min / minutesInHour / hoursInDay) % daysInYear;

        System.out.println(min + " minutes is approximately " + years + " years and " + days + " days");
    }
}
