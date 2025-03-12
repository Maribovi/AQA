package org.example.lesson_14_junit_5;

public class Factorial {
    public Factorial() {
    }

    public static int factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Нельзя вычислить факториал для отрицательных чисел");
        } else {
            int result = 1;

            for (int i = 1; i <= x; ++i) {
                result *= i;
            }

            return result;
        }
    }
}