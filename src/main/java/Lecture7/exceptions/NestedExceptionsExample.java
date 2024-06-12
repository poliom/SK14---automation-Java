package Lecture7.exceptions;

public class NestedExceptionsExample {
    public static void throwit(){
        System.out.println("throwit");
        throw new RuntimeException();
    }

    public static void notThrowit(){
        throwit();
    }

    public static void main(String[] args) {
        try{
            System.out.println("hello");
            notThrowit();
        }
        catch (ArithmeticException arEx){
            System.out.println("caught");
        }
        catch (RuntimeException rtEx){
            System.out.println("caught runtime");
        }
        catch (Exception allEx) {
            System.out.println("All other then runtime or arithmetic");
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("after");
    }
}