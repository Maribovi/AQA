package org.example.lesson_6;

public interface Geometry {

    default int perimeterTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Стороны должны быть положительными");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Неравенство треугольника не выполняется");
        return a + b + c;
    }

    default double areaTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Стороны должны быть положительными");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("Неравенство треугольника не выполняется");
        int semiPerimeterTriangle = (a + b + c) / 2;
        return Math.floor(Math.sqrt(semiPerimeterTriangle * (semiPerimeterTriangle - a) *
                (semiPerimeterTriangle - b) * (semiPerimeterTriangle - c)));
    }

    default int perimeterRectangle(int a, int b) {
        if (a <= 0 || b <= 0) throw new IllegalArgumentException("Длина и ширина должны быть положительными");
        return 2 * (a + b);
    }

    default double areaRectangle(int a, int b) {
        if (a <= 0 || b <= 0) throw new IllegalArgumentException("Длина и ширина должны быть положительными");
        return a * b;
    }

    default double perimeterCircle(int r) {
        if (r <= 0) throw new IllegalArgumentException("Радиус должен быть положительным");
        return Math.floor(2 * 3.14 * r);
    }

    default double areaCircle(int r) {
        if (r <= 0) throw new IllegalArgumentException("Радиус должен быть положительным");
        return Math.floor(3.14 * Math.pow(r, 2));
    }
}