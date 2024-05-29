package Lecture6.Examples;

public class Examples {
    public static void main(String[] args) {
//        myMethod();
//
//        //V1
//        printMessage("My first text");
//        //V2
//        String textForParam = "This is some random text";
//        printMessage(textForParam);
//
//        System.out.println("Print between methods");
//        myMethod();
//
//        printFirstName("Vidko");
//        printPersonAge("Vidko", 34);
//        calculateSum(2,4);
//        System.out.println("Sum of numbers is: " + calculateSum(3,6));
//        System.out.println(calculateSumV2(3,6));
//        checkAge(25);
//        Dog test = new Dog();
//        test.displayInfo();
        AgeValidation userAgeValidation = new AgeValidation();

        System.out.println("User birth year is: " + userAgeValidation.getBirthYear());
        userAgeValidation.setBirthYear("1985");
        System.out.println("User birth year is: " + userAgeValidation.getBirthYear());

        System.out.println("User is " + userAgeValidation.getAge() + " years old");
        userAgeValidation.setAge(28);
        System.out.println("User is " + userAgeValidation.getAge() + " years old");
        boolean isUserAdult= userAgeValidation.IsUserAdult();
        //System.out.println("User is adult: " + userAgeValidation.IsUserAdult());
        System.out.println("User is adult: " + isUserAdult);

        //if (userAgeValidation.IsUserAdult()){
        if (isUserAdult){
            System.out.println("User is Adult");
        }
        else {
            System.out.println("User is not Adult");
        }
        userAgeValidation.setAge(13);
        System.out.println("User is " + userAgeValidation.getAge() + " years old");
    }

    static void printMessage(String text){
        System.out.println("This is the text that we get: " + text);
    }

    static void myMethod() {
        // code to be executed
        System.out.println("I just got executed!");
    }

    static void printFirstName(String fname) {
        System.out.println(fname + " Refsnes");
    }

    static void printPersonAge(String fname, int age) {
        System.out.println(fname + " is " + age + " years old");
    }

    static int calculateSum(int x, int y) {
        return x + y;
    }

    static int calculateSumV2(int x, int y) {
        int sum = x + y;
        return sum;
    }

    static void checkAge(int age) {

        // If age is less than 18, print "access denied"
        if (age < 18) {
            System.out.println("Access denied - You are not old enough!");

            // If age is greater than 18, print "access granted"
        } else {
            System.out.println("Access granted - You are old enough!");
        }
    }

    static double calculateSum(double x, double y) {
        return x + y;
    }

    static long calculateSum(long x, long y) {
        return x + y;
    }
    static String calculateSum(String x, String y) {
        int xLenght = x.length();
        int yLenght = y.length();
        int totalLenght = xLenght + yLenght;

        String total = String.valueOf(totalLenght);
        //String total = ""+totalLenght;
        return total;
        //return x + y;
    }
//    static String calculateSum(String x, String y) {
//        return x + y;
//    }

    static int calculateSum(int x, int y, int z) {
        return x + y + z;
    }
}