package org.example.lesson_6;

public class Triangle implements Geometry {
    public String colourFilling;
    public String colourBoundary;
    int a;
    int b;
    int c;

    Triangle(String colourFilling, String colourBoundary, int a, int b, int c) {
        this.colourFilling = colourFilling;
        this.colourBoundary = colourBoundary;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String toString() {
        return "\n" + "Фигура: треугольник" + "\n" + "Цвет заливки: " + this.colourFilling + "\n" +
                "Цвет границы: " + this.colourBoundary + "\n" +
                "Периметр: " + this.perimeterTriangle(a, b, c) + "\n" +
                "Площадь: " + this.areaTriangle(a, b, c) + "\n";
    }
}