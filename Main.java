package org.example.lesson_10;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"11", "2", "5", "n"},
                {"5", "1", "7", "8"},
                {"9", "10", "11", "7"},
                {"3", "14", "1", "16"}
        };

        try {
            int sum = ArraySquare.sumArray(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (ArraySquare.MyArrayDataException e) {
            System.err.println("Ошибка данных в массиве: " + e.getMessage());
        } catch (ArraySquare.MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        }
    }
}