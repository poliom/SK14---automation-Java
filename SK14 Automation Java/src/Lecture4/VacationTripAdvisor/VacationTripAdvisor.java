package Lecture4.VacationTripAdvisor;

import java.util.Scanner;

public class VacationTripAdvisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of vacation (Beach/Mountain):");
        String vacationType = scanner.nextLine();

        System.out.println("Enter the budget per day per person:");
        double budgetPerDay = scanner.nextDouble();

        if (vacationType.equalsIgnoreCase("Beach")) {
            if (budgetPerDay < 50) {
                System.out.println("You should go to Bulgaria for your beach vacation.");
            } else {
                System.out.println("You should go outside Bulgaria for your beach vacation.");
            }
        } else if (vacationType.equalsIgnoreCase("Mountain")) {
            if (budgetPerDay < 30) {
                System.out.println("You should go to Bulgaria for your mountain vacation.");
            } else {
                System.out.println("You should go outside Bulgaria for your mountain vacation.");
            }
        } else {
            System.out.println("There is no information about this type of vacation.");
        }
    }
}
