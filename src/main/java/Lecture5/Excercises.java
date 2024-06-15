package Lecture5;

import java.util.Arrays;
import java.util.Scanner;
public class Excercises {
    public static void main(String[] args) {
        printDynamicMatrixElements( );
    }

    private static void printDynamicMatrixElements () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (var i = 0; i < rows; i++) {
            for (var j = 0;j < columns;j++) {
                System.out.printf("matrix[%d, %d] = ", +i, j);
            }
        }
            System.out.println("The matrix is created: " + Arrays.deepToString(matrix));
        }
    }