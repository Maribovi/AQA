package org.example.testng;

import org.example.lesson_14_junit_5.AreaTriangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaTriangleEqualityTestng {

    @Test
    public void testAreaTriangle() {
        String expected = "2,90";
        String actual = AreaTriangle.areaTriangle(2.0, 3.0, 4.0);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }

    @Test
    public void testAreaTriangle1() {
        String expected = "Треугольник не существует";
        String actual = AreaTriangle.areaTriangle(1.0, 2.0, 3.0);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }

    @Test
    public void testAreaTriangle2() {
        String expected = "Треугольник не существует";
        String actual = AreaTriangle.areaTriangle(1.0, 0.0, 1.0);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }

    @Test
    public void testAreaTriangle3() {
        String expected = "Треугольник не существует";
        String actual = AreaTriangle.areaTriangle(-1.0, 1.0, 1.0);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }

    @Test(description = "Тест с отрицательным результатом")
    public void testAreaTriangle4() {
        String expected = "Треугольник";
        String actual = AreaTriangle.areaTriangle(1.0, 0.0, 1.0);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }
}