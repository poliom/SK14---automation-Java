package Lecture8.examples.abstraction.exampleinterface;

public class Examples {
    public static void main(String[] args) {
        Pig myPig = new Pig();  // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
        String eat = myPig.eat();
        System.out.println("What my pig is eating: " + eat);
    }
}
