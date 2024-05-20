package Lecture2;

public class homework4 {

    public static void main (String[] args) {
    }

    {
        int treeHeight = 5;
        for (int i = 0; i < treeHeight; i++) {
            for (int j = 0; j < treeHeight - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }}}