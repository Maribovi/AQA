package org.example.lesson_14_testng;

import static org.example.lesson_14_junit_5.CompareNumbers.compare;
import static org.example.lesson_14_junit_5.Count.count;

public class Main {
    public static void main(String[] args) {
        System.out.println("Факториал " + Factorial.factorial(6));
        System.out.println("Площадь треугольника " + AreaTriangle.areaTriangle((double) 2.0F, (double) 3.0F, (double) 4.0F));

        count(4, 5, '/');

        System.out.println(compare(1, 10));

        System.out.println(Factorial.factorial(-1));
    }
}