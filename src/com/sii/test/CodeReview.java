package com.sii.test;

public class CodeReview {

    public static void main(String[] args) {

        Circle c = new Circle();
        c.a = 6;

        Square s = new Square();
        s.a = 9;

        Rectangle r = new Rectangle();
        r.a = 9;
        r.b = 10;

        System.out.println(c.calculateArea());
        System.out.println(s.getArea());
        System.out.println(r.getArea());

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
