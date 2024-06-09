package Lecture8;

public class Circle extends Shape {
    private Double parameter;

    public Circle (Double parameter) {
        this.parameter = parameter;
    }

    public Circle () {

    }

    @Override
    public Double getArea (double v) {
        double v1 = Math.PI;
        return v1 * parameter * parameter;
    }

    @Override
    public Double getPerimeter (double v) {
        v = 2 * Math.PI;
        return v * parameter;
    }
}
