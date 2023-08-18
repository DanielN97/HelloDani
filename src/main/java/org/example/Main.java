package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double totalArea = 0.0;
    static String response = "";

    public static void main(String[] args) {
        //Introduction
        System.out.println("Welcome to painters' best friend!");
        System.out.println("Here you can calculate the total cost for the job including paint and labour");
        System.out.println();

        System.out.println("Firstly, lets calculate all the surfaces using one of the following shapes: rectangle, triangle, or circle (or part of it)");
        System.out.println("Separate the surface you want to paint in a combination of above mentioned shapes");
        System.out.println("Then input the type of shape and its dimensions in meters");
        System.out.println();


        //Adding areas
        do {
            String shape = decideShape();

            totalArea += calculateAreaDependingOnShape(shape);

            System.out.println("Thank you, I have added the area to the total area (total: " + totalArea + " square meters)");
            System.out.println();
            System.out.println("If you want to add more shapes type \"yes\" or type \"no\" if you want to end adding shapes");
            System.out.println();

            scanner.nextLine();
            response = scanner.nextLine();
            while (!(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no"))) {
                System.out.println("Wrong input");
                System.out.println("If you want to add more areas type \"yes\" or type \"no\" if you want to end adding areas");

                response = scanner.nextLine();
            }
        }
        while (response.equalsIgnoreCase("yes"));


        //Ask for subtraction
        System.out.println("Do you have any area that you would like to subtract from the total area (like windows or doors)");
        System.out.println("Type \"yes\" or \"no\"");

        response = scanner.nextLine();
        while (!(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no"))) {
            System.out.println("Wrong input");
            System.out.println("Type \"yes\" or \"no\"");

            response = scanner.nextLine();
        }


        //Subtracting areas
        if (response.equalsIgnoreCase("yes")) {
            System.out.println();
            System.out.println("Now input the type of shape that you want to subtract and its dimensions in meters");
            System.out.println();

            while (response.equalsIgnoreCase("yes")) {
                String shape = decideShape();

                totalArea -= calculateAreaDependingOnShape(shape);

                System.out.println("Thank you, I have subtracted the area from the total area (total: " + totalArea + " square meters)");
                System.out.println();
                System.out.println("If you want to subtract more areas type \"yes\" or type \"no\" if you want to end subtracting areas");

                scanner.nextLine();
                response = scanner.nextLine();
                while (!(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no"))) {
                    System.out.println("Wrong input");
                    System.out.println("If you want to subtract more areas type \"yes\" or type \"no\" if you want to end subtracting areas");

                    response = scanner.nextLine();
                }
            }
        }


        //Calculate costs
        System.out.println();
        System.out.println("Finally, I calculate the total cost for the job.");
        double totalCost = 0.0;

        System.out.println("Input the cost of the paint per square meter:");
        double costOfPaintPerArea = 0.0;

        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Wrong input");
                System.out.println("Please input a positive number");

                scanner.next();
            } else {
                costOfPaintPerArea = scanner.nextDouble();
                if (costOfPaintPerArea > 0) {
                    break;
                } else {
                    System.out.println("Wrong input");
                    System.out.println("Please input a positive number");
                }
            }
        }

        totalCost += totalArea * costOfPaintPerArea;


        System.out.println();
        System.out.println("Input the amount the square meters you can cover per hour:");
        double areaPerHourCovered = 0.0;

        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Wrong input");
                System.out.println("Please input a positive number");

                scanner.next();
            } else {
                areaPerHourCovered = scanner.nextDouble();
                if (areaPerHourCovered > 0) {
                    break;
                } else {
                    System.out.println("Wrong input");
                    System.out.println("Please input a positive number");
                }
            }
        }

        System.out.println();
        System.out.println("How much do you charge per hour:");
        double payPerHour = 0.0;

        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("Wrong input");
                System.out.println("Please input a positive number");

                scanner.next();
            } else {
                payPerHour = scanner.nextDouble();
                if (payPerHour > 0) {
                    break;
                } else {
                    System.out.println("Wrong input");
                    System.out.println("Please input a positive number");
                }
            }
        }

        totalCost += totalArea / areaPerHourCovered * payPerHour;

        System.out.println();
        System.out.println("The final cost for the job is: £" + Math.round(totalCost * 100.0) / 100.0);
        System.out.println("Thank you for using the program. See you later!");
    }

    public static String decideShape() {
        System.out.println("Please, type \"1\" for rectangle;");
        System.out.println("Please, type \"2\" for triangle;");
        System.out.println("Please, type \"3\" for circle (or part of it)");

        String shape = scanner.nextLine();

        while (!(shape.equals("1") || shape.equals("2") || shape.equals("3"))) {
            System.out.println("Wrong input");
            System.out.println("Please, type \"1\" for rectangle;");
            System.out.println("Please, type \"2\" for triangle;");
            System.out.println("Please, type \"3\" for circle (or part of it)");

            shape = scanner.nextLine();
        }

        return shape;
    }

    public static double calculateAreaDependingOnShape(String shape) {
        double area = 0.0;

        switch (shape) {
            case "1":
                System.out.println("Please, input the width of the rectangle:");
                double widthRectangle = scanner.nextDouble();

                while (widthRectangle <= 0) {
                    System.out.println("Wrong input");
                    System.out.println("Input a positive value");

                    widthRectangle = scanner.nextDouble();
                }

                System.out.println("Please, input the height of the rectangle:");
                double heightRectangle = scanner.nextDouble();

                while (heightRectangle <= 0) {
                    System.out.println("Wrong input");
                    System.out.println("Input a positive value");

                    heightRectangle = scanner.nextDouble();
                }

                Shape rectangle = new Rectangle(widthRectangle, heightRectangle);
                area = rectangle.calculateArea();

                break;
            case "2":
                System.out.println("Please, input the width of the triangle:");
                double widthTriangle = scanner.nextDouble();

                while (widthTriangle <= 0) {
                    System.out.println("Wrong input");
                    System.out.println("Input a positive value");

                    widthTriangle = scanner.nextDouble();
                }

                System.out.println("Please, input the height of the rectangle:");
                double heightTriangle = scanner.nextDouble();

                while (heightTriangle <= 0) {
                    System.out.println("Wrong input");
                    System.out.println("Input a positive value");

                    heightTriangle = scanner.nextDouble();
                }

                Shape triangle = new Triangle(widthTriangle, heightTriangle);
                area = triangle.calculateArea();

                break;
            case "3":
                System.out.println("Please, input the radius of the circle:");
                double radiusCircle = scanner.nextDouble();

                while (radiusCircle <= 0) {
                    System.out.println("Wrong input");
                    System.out.println("Input a positive value");

                    radiusCircle = scanner.nextDouble();
                }

                System.out.println("Please, input the fraction of the circle:");
                double fractionCircle = scanner.nextDouble();

                while ((fractionCircle <= 0 || fractionCircle > 1)) {
                    System.out.println("Wrong input");
                    System.out.println("Input a number between 0 and 1");

                    fractionCircle = scanner.nextDouble();
                }

                Shape circle = new Circle(radiusCircle, fractionCircle);
                area = circle.calculateArea();

                break;
        }

        return area;
    }
}