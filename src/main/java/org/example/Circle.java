package org.example;

public class Circle implements Shape{
    private double radius;
    private double fraction;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getFraction() {
        return fraction;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    public Circle(double radius, double fraction) {
        this.radius = radius;
        this.fraction = fraction;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2) * fraction;
    }
}
