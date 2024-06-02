package Lecture6;

public class NumberIsEven {
    public static void main(String[] args) {
        int number1 = 4;
        int number2 =11;

        boolean isEven1 = isEven(number1);
        System.out.println(number1 + " is even? " + isEven1);

        boolean isEven2 = isEven(number2);
        System.out.println(number2 + " is even? " + isEven2);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
