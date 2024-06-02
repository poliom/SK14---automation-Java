package Lecture6;

public class findAvgNumber {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        int avg = arr[2];

        if (arr[1] < avg) {
            avg = arr[1];
        }

        System.out.println("The average number of the displayed array is: " + avg);
    }
}