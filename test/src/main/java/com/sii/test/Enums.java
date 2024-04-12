package com.sii.test;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

/**
 * Refactor the code.  Please use enum that will support Strategy Pattern
 */
public class Enums {
   

   
   public static void main(String @NotNull [] args) {
      if(args.length != 3) System.out.println("Please provide an operator(+,-,*,/,^"); 
      String operation = args[1];
      final double a = Double.parseDouble(args[0]); 
      final double b = Double.parseDouble(args[2]);

      Operator operator = Operator.getBySymbol(operation);
      double calculate = operator.calculate(a, b);
      System.out.println(calculate);

//      Plus plusOperation = new Plus();
//      Minus minusOperation = new Minus();
//      Multiply multiplyOperation = new Multiply();
//      Divide divideOperation = new Divide();
//      Power powerOperation = new Power();
//      
//      if (operation.equals("+")) {System.out.println(plusOperation.calculate(a,b));}
//      if (operation.equals("-")) {System.out.println(minusOperation.calculate(a,b));}
//      if (operation.equals("*")) {System.out.println(multiplyOperation.calculate(a,b));}
//      if (operation.equals("/")) {System.out.println(divideOperation.calculate(a,b));}
//      if (operation.equals("^")) {System.out.println(powerOperation.calculate(a,b));}
   }
}


enum Operator {
   PLUS("+", new Plus()),
   MINUS("-", new Minus()),
   MULTI("*", new Multiply()),
   DIVIDE("*", new Divide()),
   POW("^", new Plus()),
   ;

   private final String operationSymbol;
   
   private final Calculator calculator;

   Operator(String operationSymbol, Calculator calculator) {
      this.operationSymbol = operationSymbol;
       this.calculator = calculator;
   }

   public static Operator getBySymbol(String operationSymbol) {
      return Arrays.stream(values())
              .filter(i -> Objects.equals(i.operationSymbol, operationSymbol))
              .findFirst()
              .orElseThrow(UnsupportedOperationException::new);
   }
   
   public double calculate(double a, double b) {
      return calculator.calculate(a, b);
   }

}

interface Calculator {
   double calculate(double a, double b);
}

class Plus implements Calculator {
   
   public double calculate(double a, double b) {
      return a + b;
   }
}

class Minus implements Calculator{
   
   public double calculate(double a, double b) {
      return a - b;
   }
}

class Multiply implements Calculator  {
   
   public double calculate(double a, double b) {
      return a * b;
   }
}

class Divide implements Calculator {
   
   public double calculate(double a, double b) {
      return a / b;
   }
}

class Power implements Calculator {
   
   public double calculate(double a, double b) {
      return Math.pow(a, b);
   }
}
