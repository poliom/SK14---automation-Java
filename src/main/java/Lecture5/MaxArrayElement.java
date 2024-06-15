package Lecture5;

public class MaxArrayElement {
    public static void main(String[] args) {
        int[] arr = {10, 2, 20, 14, 25, 40};
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Biggest element in the displayed array: " + max);
    }
}
