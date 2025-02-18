package org.example.lesson_10;

public class ArraySquare {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("размер массива должен быть 4x4.");
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int n = Integer.parseInt(array[i][j]);
                    sum += n;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j], i, j);
                }
            }
        }
        return sum;
    }

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        private final int row;
        private final int col;

        public MyArrayDataException(String message, int row, int col) {
            super(message);
            this.row = row;
            this.col = col;
        }

       public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}