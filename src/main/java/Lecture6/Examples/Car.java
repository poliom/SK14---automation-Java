package Lecture6.Examples;

public class Car {
    public Car(String model, boolean isNew, String color){
        this.color = color;
        this.isNew = isNew;
        this.model = model;
    }
    private String model;
    private String color;
    private boolean isNew;

    public String getModel(){
        return model;
    }

}
