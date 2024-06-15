package Lecture6;

public class findIfPalindrome {
    public static void main(String[] args) {
        int number1 = 1234321;
        int number2 = 12345678;

        boolean isPalindrome1 = isPalindrome(number1);
        System.out.println(number1 + " is a palindrome? " + isPalindrome1);

        boolean isPalindrome2 = isPalindrome(number2);
        System.out.println(number2 + " is a palindrome? " + isPalindrome2);
    }

    public static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverseNumber = 0;

        while (number != 0) {
            int remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number /= 10;
        }
        return originalNumber == reverseNumber;
    }
}
