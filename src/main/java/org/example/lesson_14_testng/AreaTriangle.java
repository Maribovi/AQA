package org.example.lesson_14_testng;

public class AreaTriangle {
    public AreaTriangle() {
    }

    public static String areaTriangle(double a, double b, double c) {
        if (!(a + b <= c) && !(a + c <= b) && !(b + c <= a)) {
            double s = (a + b + c) / (double) 2.0F;
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            return String.format("%.2f", area);
        } else {
            return "Треугольник не существует";
        }
    }
}