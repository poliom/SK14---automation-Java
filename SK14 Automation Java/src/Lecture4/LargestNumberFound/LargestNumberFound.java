package Lecture4.LargestNumberFound;

public class LargestNumberFound {
    public static void main(String[] args) {
        int[] numbers = new int[]{28, 2, 4, 8, 16, 20};

        int largestNumber = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largestNumber);
        }

        System.out.println("The largest number in the array is: " + largestNumber);
    }
}
