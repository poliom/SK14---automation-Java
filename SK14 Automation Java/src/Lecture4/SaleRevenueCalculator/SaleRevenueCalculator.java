package Lecture4.SaleRevenueCalculator;

import java.util.Scanner;

public class SaleRevenueCalculator { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter unit price:");
    double unitPrice = scanner.nextDouble();

    System.out.println("Enter quantity:");
    int quantity = scanner.nextInt();

    double discountRate = 0;
    if (quantity >= 100 && quantity <= 120) {
        discountRate = 0.15;
    } else if (quantity > 120) {
        discountRate = 0.20;
    }

    double revenue = unitPrice * quantity;
    double discount = revenue * discountRate;

    System.out.println("The revenue from sale: $" + revenue);
    System.out.println("Discount: $" + discount + "(" + (discountRate * 100) + "%)");
}
}
