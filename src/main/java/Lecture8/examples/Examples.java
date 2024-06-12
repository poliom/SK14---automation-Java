package Lecture8.examples;

import Lecture8.examples.ClassExample;

public class Examples {
    public static void main(String[] args) {
        testMyCar();
    }

    static void testObjectCreation() {
        ClassExample myObject = new ClassExample();
        System.out.println(myObject.x);
    }

    static void testModifyClassAttributes() {
        ClassExample myObject = new ClassExample();
        System.out.println("FirstObject: " + myObject.x);
        myObject.x = 30;
        System.out.println("FirstObject: " + myObject.x);

        ClassExample myObject2 = new ClassExample();
        myObject2.x = 20;
        System.out.println("SecondObject: " + myObject2.x);
        System.out.println("FirstObject: " + myObject.x);

        ClassExample myObject3 = new ClassExample();
        System.out.println("LastObject: " + myObject3.x);
        System.out.println("SecondObject: " + myObject2.x);
        System.out.println("FirstObject: " + myObject.x);
    }

    static void testFinalAttribute() {
        ClassExample myObject = new ClassExample();
        //myObject.z = 30; //this is not allowed
        System.out.println(myObject.z);
    }

    static void testClassMethods() {
        ClassExample.printHello();
        ClassExample myObject = new ClassExample();
        myObject.printHelloOfObject();
    }

    static void testClassAttributes(){
        ClassExample.printHello();
        ClassExample.y = 20;
        ClassExample.printHello();

        ClassExample myObject = new ClassExample();
        myObject.x = 40;
        System.out.println(myObject.x);
    }

    static void testMyCar(){
        Car vidkoNewCar = new Car("Audi", "A4", 3.5, 2.3, 3600);
        Car vidkoNewCar1 = new Car("AudiNew", "A4", 300);
        System.out.println(vidkoNewCar.brand);
        System.out.println(vidkoNewCar1.brand);
        System.out.println(vidkoNewCar.brand + " , " + vidkoNewCar1.brand);
        System.out.print(vidkoNewCar.brand);
        System.out.print(vidkoNewCar1.brand);
        System.out.println();
        System.out.print(vidkoNewCar.brand + vidkoNewCar1.brand);
        System.out.println();
        Car.PrintCar(vidkoNewCar);
        Car.PrintCar(vidkoNewCar1);
    }
}
