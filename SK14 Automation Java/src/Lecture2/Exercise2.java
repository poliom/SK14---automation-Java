package Lecture2;

public class Exercise2 {

    // Print the perimeter of a triangle by given sides. Use formula to calculate it.
    public static void main(String[] args) {
        int a = 7;
        int b = 4;
        int c = 7;

        int perimeter = a + b + c;
        System.out.println("Perimeter is: " + perimeter);
        testMethod(a);
    }
    public static void testMethod(int test){
        System.out.println("This is test method will print a number. Number is: " + test);
    }
}