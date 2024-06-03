package Lecture7.constructors;

import Lecture7.constructors.vehicle.Car;

public class Examples {
    public static void main(String[] args) {
//        Employee yordan = createEmployee();
//        Employee tsveta = new Employee("Tsveta", "Vasileva", 1999);
//        Employee vidko = new Employee("Vidko");
//        Employee assya = new Employee(tsveta.getFirstName(), tsveta.getLastName());
//        System.out.println(yordan.getLastName());
//        System.out.println(vidko.getLastName());
//        System.out.println(tsveta.getLastName());
//        System.out.println(assya.getLastName());
//        System.out.println();
//        yordan.setLastName("Zhishkin");
//        tsveta.setBirthYear(2000);
//        System.out.println(yordan.getLastName());
//        System.out.println(vidko.getLastName());
//        System.out.println(tsveta.getBirthYear());
//        System.out.println(assya.getBirthYear());

        Car bmw = new Car("KM8649BM", "BMW");
    }

    static Employee createEmployee() {
        Employee employee = new Employee();
        return employee;
    }
}