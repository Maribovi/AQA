package org.example.lesson_14_junit_5;

public class CompareNumbers {
    public static String compare(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
           return "Первое число больше второго.";
        } else if (firstNumber < secondNumber) {
           return "Первое число меньше второго.";
        } else {
           return "Оба числа равны.";
        }
    }
}