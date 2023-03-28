package com.sii.test;

import java.util.Arrays;

public class CodeReview {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.a = 6;

        Square s = new Square();
        s.a = 9;

        Rectangle r = new Rectangle();
        r.a = 9;
        r.b = 10;

        Arrays.asList(c, s, r).forEach(i -> {
            double area = 0d;
            if (i instanceof Circle) area = ((Circle) i).calculateArea();
            if (i instanceof Square) area = ((Square) i).getArea();
            if (i instanceof Rectangle) area = ((Rectangle) i).getArea();
            System.out.println("Area: " + area);
        });
    }
}

class Circle {

    public int a;

    public double calculateArea() {

        return 3.14 * a * a;
    }

}

class Square {

    int a;

    public double getArea() {

        return a * a;
    }

}

class Rectangle {

    int a;

    public int b;

    public double getArea() {

        return a * b;
    }

//    public double calcualteCircuit() {
//
//        return 2 * (a + b);
//    }

}
