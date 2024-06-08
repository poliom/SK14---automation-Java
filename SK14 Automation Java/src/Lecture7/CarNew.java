package Lecture7;

public class CarNew {
    private String name;
    private String color;
    private int releaseYear;
    private int horsePower;
    private boolean secondHand;

    public CarNew (String name, String color, int releaseYear, int horsePower, boolean secondHand) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
        this.secondHand = secondHand;
    }

    public CarNew (String name, String color, boolean secondHand) {
        this(name, color, -1, -1 , secondHand);
    }

    public CarNew (String name, String color, int releaseYear, int horsePower) {
        this(name, color, releaseYear, horsePower, false);
    }

    public CarNew (String name, int releaseYear, int horsePower, boolean secondHand) {
        this(name, "N/A", releaseYear, horsePower, secondHand);
    }
}
