package org.example.lesson_10;

public class ArraySquare {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int n = Integer.parseInt(array[i][j]);
                    sum += n;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j], i, j);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new MyArraySizeException("размер массива должен быть 4x4.");
                }
            }
        }
        return sum;
    }
}