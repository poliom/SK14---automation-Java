package Lecture5;

import java.util.Scanner;

public class DynamicMatrix {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int columns = scanner.nextInt();

        System.out.println("Enter the matrix numbers: ");
        int[][] matrix = new int[rows][columns];

        for (var i = 0; i < rows; i++)
            for (var j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        System.out.println("Matrix numbers:");

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }