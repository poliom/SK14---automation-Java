package Lecture6;

public class findSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 2, 20};
        int i1 = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < i1) {
                i1 = arr[i];
            }
        }

        System.out.println("Biggest element in the displayed array: " + i1);
    }
}