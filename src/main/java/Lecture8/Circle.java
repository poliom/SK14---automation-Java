package Lecture8;

public class Circle extends Shape {

    public Circle () {

    }

    @Override
    public Double getArea (double radius) {
        double numberPI = Math.PI;
        return numberPI * radius * radius;
    }

    @Override
    public Double getPerimeter (double radius) {
        double twiceNumberPI = 2 * Math.PI;
        return radius * twiceNumberPI;
    }
}
