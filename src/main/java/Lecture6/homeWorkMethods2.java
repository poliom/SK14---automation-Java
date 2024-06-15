package Lecture6;

public class homeWorkMethods2 {
    public static void MyNewMethod (String message) {
        int middleIndex = message.length() / 2;
        char middleChar = message.charAt(middleIndex);
        System.out.println("The middle character is: " + middleChar);
    }

    public static void main(String[] args) {
        MyNewMethod("Hello, Friends");
    }
}
