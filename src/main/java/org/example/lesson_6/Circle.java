package org.example.lesson_6;

public class Circle implements Geometry {
    public String colourFilling;
    public String colourBoundary;
    public int r;

    Circle(String colourFilling, String colourBoundary, int r) {
        this.colourFilling = colourFilling;
        this.colourBoundary = colourBoundary;
        this.r = r;
    }

    public String toString() {
        return  "\n" +"Фигура: круг" + "\n" + "Цвет заливки: " + this.colourFilling + "\n" +
                "Цвет границы: " + this.colourBoundary + "\n" +
                "Периметр: " + this.perimeterCircle(r) + "\n" +
                "Площадь: " + this.areaCircle(r) + "\n";
    }
}
