package Lecture6.Examples;

public class FinalDemo {
    public static void main (String[] args){
        Car bmw = new Car("BMW 330", true, "Red");
        Car ford = new Car("Ford Fiesta", false, "Black");

        final Car myCar = bmw;
        Car mySecondCar = bmw;
        //myCar = ford;
        mySecondCar = ford;

        final StringBuilder sb = new StringBuilder("Geeks");
        System.out.println(sb);
        sb.append("ForGeeks");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        //StringBuilder newSBValue = new StringBuilder("Test");
        //sb = newSBValue;
    }
}
