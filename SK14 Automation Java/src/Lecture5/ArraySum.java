package Lecture5;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of array elements: " + sum);
    }
}


