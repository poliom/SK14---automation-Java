package Lecture9;

public class Exercise {
    public static void main(String[] args) {
        Person tsveti = new Person("Tsveti", "orthodox","Bulgarian", "Bulgarian","Female", "1343304865",false, "MCOT", "Bulgaria");
        System.out.println(tsveti.getCountry());
        System.out.println(tsveti.getSex());
        System.out.println(tsveti.getAge());
        System.out.println(tsveti.getBirthDate());
        tsveti.setCountry("Italy");
        System.out.println(tsveti.getCountry());
        System.out.println("Can take a loan: " + tsveti.canTakeLoan());
        System.out.println("Is adult: " + tsveti.isAdult());
        tsveti.celebrateEaster();
        tsveti.sayHello();
    }
}
