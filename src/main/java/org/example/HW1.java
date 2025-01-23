package org.example;

import java.util.Arrays;

public class HW1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSum(1, 10));
        checkIsPositive(5);
        System.out.println(booleanIsPositive(0));
        printLine("мама", 10);
        System.out.println(isLeapYear(-3));
        arrayZeroOne();
        arrayFillIn();
        arrayMultiply();
        twoDimensionalArray();
        arrayLength(2, 4);
    }

    static void printThreeWords() {
        System.out.print("Orange" + "\n" + "Banana" + "\n" + "Apple" + "\n");
    }

    static void checkSumSign() {
        int a = 0;
        int b = -1;
        int sum = a + b;

        if (sum >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    static void printColor() {
        int value = 5;

        if (value <= 0) System.out.println("Красный");
        if (value > 0 && value <= 100) System.out.println("Желтый");
        if (value > 100) System.out.println("Зеленый");
    }

    static void compareNumbers() {
        int a = 1;
        int b = 2;

        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

    static boolean checkSum(int a, int b) {
        int sum = a + b;

        return (sum >= 10 && sum <= 20);
    }

    static void checkIsPositive(int x) {
        if (x >= 0) System.out.println("Положительное");
        else System.out.println("Отрицательное");
    }

    static boolean booleanIsPositive(int x) {
        return (x < 0);
    }

    static void printLine(String a, int b) {
        for (int i = 1; i <= b; i++) {
            System.out.println(a);
        }
    }

    static boolean isLeapYear(int y) {
        if (y > 0) {
            return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
        }
        System.out.println("Год должен быть больше нуля");
        return false;
    }

    static void arrayZeroOne() {
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else array[i] = 1;
        }
        System.out.println(Arrays.toString(array));
    }

    static void arrayFillIn() {
        int[] arr = new int[100];
        int x = 1;

        for (int i = 0; i < arr.length; i++, x++) {
            arr[i] = x;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void arrayMultiply() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void twoDimensionalArray() {
        int[][] arr = new int[8][8];
        int j;

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i].length;
            for (j = 0; j < arr[i].length; j++, x--) {
                if (i == j || i == x - 1) {
                    arr[i][j] = 1;
                } else arr[i][j] = 0;
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] arrayLength(int len, int initialValue) {
        int[] arr = new int[len];

        for (int a:arr) {
            arr[a] = initialValue;
            System.out.print(arr[a] + " ");
        }
        return arr;
    }
}





