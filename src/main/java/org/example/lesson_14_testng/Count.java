package org.example.lesson_14_testng;

public class Count {
    public static double count(int num1, int num2, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                System.out.println("Результат арифметического действия: " + num1 + "+" + num2 + "=" + (num1 + num2));
                return result = num1 + num2;
            case '-':
                System.out.println("Результат арифметического действия: " + num1 + "-" + num2 + "=" + (num1 - num2));
                return result = num1 - num2;
            case '*':
                System.out.println("Результат арифметического действия: " + num1 + "*" + num2 + "=" + (num1 * num2));
                return result = num1 * num2;
            case '/':
                if (num2 != 0) {
                    System.out.println("Результат арифметического действия: " + num1 + "/" + num2 + "=" + ((double) num1 / num2));
                    return result = (double) num1 /num2;
                } else {
                    System.out.println("Ошибка: деление на ноль невозможно.");
                }
                break;
            default:
                System.out.println("Ошибка: неверная операция.");
                break;
        }
        return result;
    }
}