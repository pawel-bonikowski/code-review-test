package com.sii.test;

import org.jetbrains.annotations.NotNull;

/**
 * Refactor the code.  Please use enum that will support Strategy Pattern
 */
public class Enums {

   public static void main(String @NotNull [] args) {
      if(args.length != 3) System.out.println("Please provide an operator(+,-,*,/,^"); 
      String operation = args[1];
      final double a = Double.parseDouble(args[0]); 
      final double b = Double.parseDouble(args[2]);
      
      Plus plusOperation = new Plus();
      Minus minusOperation = new Minus();
      Multiply multiplyOperation = new Multiply();
      Divide divideOperation = new Divide();
      Power powerOperation = new Power();
      
      if (operation.equals("+")) {System.out.println(plusOperation.calculate(a,b));}
      if (operation.equals("-")) {System.out.println(minusOperation.calculate(a,b));}
      if (operation.equals("*")) {System.out.println(multiplyOperation.calculate(a,b));}
      if (operation.equals("/")) {System.out.println(divideOperation.calculate(a,b));}
      if (operation.equals("^")) {System.out.println(powerOperation.calculate(a,b));}
   }
}


class Plus  {
   
   public double calculate(double a, double b) {
      return a + b;
   }
}

class Minus {
   
   public double calculate(double a, double b) {
      return a - b;
   }
}

class Multiply  {
   
   public double calculate(double a, double b) {
      return a * b;
   }
}

class Divide  {
   
   public double calculate(double a, double b) {
      return a / b;
   }
}

class Power  {
   
   public double calculate(double a, double b) {
      return Math.pow(a, b);
   }
}
