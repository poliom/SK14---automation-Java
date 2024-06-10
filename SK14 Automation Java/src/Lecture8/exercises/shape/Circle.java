package Lecture8.exercises.shape;

public class Circle extends Shape {
    private double radius;
    public void setRadius(Double radius){
        this.radius = radius;
    }

    Double getArea() {
        return Math.PI * (radius * radius);
    }

    Double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    Double getArea(Double radius) {
        return Math.PI * (radius * radius);
    }

    @Override
    Double getPerimeter(Double radius) {
        return 2 * Math.PI * radius;
    }
}
