package org.example.lesson_10;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"8", "6", "7", "3"},
                {"5", "1", "7", "1"},
                {"9", "10", "11", "9"},
                {"14", "4", "9", "5"}
        };

        try {
            int sum = ArraySquare.sumArray(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных в массиве: " + e.getMessage());
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        }
    }
}