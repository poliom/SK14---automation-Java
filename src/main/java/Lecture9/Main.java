package Lecture9;

public class Main {
    public static void main(String[] args) {
        Person tsveti = new Person("Tsveti", "Orthodox Christian","Bulgarian", "Bulgarian","Female", "8303301234",true, "Coordinator", "Bulgaria");
        System.out.println(tsveti.getCountry());
        System.out.println(tsveti.getSex());
        System.out.println(tsveti.getAge());
        System.out.println(tsveti.getBirthDate());
        tsveti.setCountry("Bulgaria");
        System.out.println(tsveti.getCountry());
        System.out.println("Can take a loan: " + tsveti.canTakeLoan());
        System.out.println("Is an adult: " + tsveti.isAdult());
        tsveti.celebrateEaster();
        tsveti.sayHello();
        //System.out.println("Bulgarian part:");
        System.out.println("Italian part:");
        Italian italian = new Italian("Carla","Orthodox Christian","ºitalian", "Italian","Female", "1343304865",true, null, "Italy");
        // bulgarian.sayHello("Здравейте, радвам се да ви видя!");
        //bulgarian.celebrateEaster();
        // bulgarian.dance("salsa");
        //bulgarian.setHasJob(true);
       // bulgarian.hasWinter("winter");
        System.out.println(italian.getCountry());
        System.out.println("Can take a loan: " + italian.canTakeLoan());
        System.out.println("Is an adult: " + italian.isAdult());
        italian.sayHello("");
        italian.celebrateEaster();
        italian.hasJob("");
        italian.hasPasta("");
    }
}
