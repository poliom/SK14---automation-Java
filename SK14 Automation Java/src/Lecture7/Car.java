package Lecture7;

public class Car{

    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHand) {
        var name1 = name != null ? name : "N/A";
        var color1 = color != null ? color : "N/A";
        int releaseYear1 = releaseYear > 0 ? releaseYear : 1;
        int horsePower1 = horsePower > 0 ? horsePower : 1;
        secondHand = secondHand;
    }
    public Car(String name, String color, boolean secondHand) {
        this(name, color, 1, 1, secondHand);

    }

    public static class Main {
        public static void main(String[] args) {
            Car car1 = new Car("BMW", "Purple", 2018, 180, true);
        }
    }
}
