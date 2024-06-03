package Lecture8.examples.abstraction.exampleinterface;

public class Pig implements Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
    public void sleep() {
        // The body of sleep() is provided here
        System.out.println("Zzz");
    }
    public String eat(){
        System.out.println("Everything");
        return "Everything";
    }
}
