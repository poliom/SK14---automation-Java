package Lecture8.examples;

public class Car {
    String brand;
    String model;
    double length;
    double width;
    double weight;
    int horsePower;
    int maxSpeed;

    Car(String brand, String model, double length, double width, double weight) {
        this.brand = brand;
        this.model = model;
        this.length = length;
        this.width = width;
        this.weight = weight;
    }

    Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public static void PrintCar(Car theCar){
        System.out.println(theCar.brand);
        System.out.println(theCar.model);
        System.out.println(theCar.horsePower);
        System.out.println(theCar.maxSpeed);
        System.out.println(theCar.width);
        System.out.println(theCar.length);
        System.out.println(theCar.weight);
    }
}
