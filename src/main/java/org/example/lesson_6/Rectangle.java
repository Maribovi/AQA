package org.example.lesson_6;

public class Rectangle implements Geometry {
    public String colourFilling;
    public String colourBoundary;
    public int a;
    public int b;

    Rectangle(String colourFilling, String colourBoundary, int a, int b) {
        this.colourFilling = colourFilling;
        this.colourBoundary = colourBoundary;
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return  "\n" + "Фигура: прямоугольник" + "\n" + "Цвет заливки: " + this.colourFilling + "\n" +
                "Цвет границы: " + this.colourBoundary + "\n" +
                "Периметр: " + this.perimeterRectangle(a, b) + "\n" +
                "Площадь: " + this.areaRectangle(a, b) + "\n";
    }
}