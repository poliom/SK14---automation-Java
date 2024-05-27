package Lecture2;

public class PineTree {
    public static void main (String[] args) {
        drawPineTree();
    }

    public static void drawPineTree () {
        int rows = 5; // Number of rows in the tree

        for (int i = 1;i <= rows;i++) {
            for (int j = 1;j <= rows - i;j++) {
                System.out.print(" "); // Print spaces before the asterisks
            }

            for (int k = 1;k <= ( 2 * i ) - 1;k++) {
                System.out.print("*"); // Print asterisks
            }

            System.out.println(); // Move to the next line
        }
    }
}
