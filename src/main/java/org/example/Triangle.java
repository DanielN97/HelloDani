package org.example;

public class Triangle implements Shape{
    private double width;
    private double height;

    public double getBase() {
        return width;
    }

    public void setBase(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height / 2;
    }
}
