package org.example.junit;

import org.example.lesson_14_junit_5.AreaTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AreaTriangleEqualityTests {
    String expected = "2,90";
    String actual = AreaTriangle.areaTriangle((double) 2.0F, (double) 3.0F, (double) 4.0F);
    String expected1 = "Треугольник не существует";
    String actual1 = AreaTriangle.areaTriangle((double) 1.0F, (double) 2.0F, (double) 3.0F);
    String expected2 = "Треугольник не существует";
    String actual2 = AreaTriangle.areaTriangle((double) 1.0F, (double) 0.0F, (double) 1.0F);
    String expected3 = "Треугольник не существует";
    String actual3 = AreaTriangle.areaTriangle((double) -1.0F, (double) 1.0F, (double) 1.0F);
    String expected4 = "Треугольник";
    String actual4 = AreaTriangle.areaTriangle((double) 1.0F, (double) 0.0F, (double) 1.0F);

    @Test
    public void testAreaTriangle() {
        Assertions.assertEquals(this.expected, this.actual, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected);
        System.out.println("Фактическое значение: " + this.actual);
    }

    @Test
    public void testAreaTriangle1() {
        Assertions.assertEquals(this.expected1, this.actual1, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected1);
        System.out.println("Фактическое значение: " + this.actual1);
    }

    @Test
    public void testAreaTriangle2() {
        Assertions.assertEquals(this.expected2, this.actual2, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected2);
        System.out.println("Фактическое значение: " + this.actual2);
    }

    @Test
    public void testAreaTriangle3() {
        Assertions.assertEquals(this.expected3, this.actual3, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected3);
        System.out.println("Фактическое значение: " + this.actual3);
    }

    @Test
    @DisplayName("Тест с отрицательным результатом")
    public void testAreaTriangle4() {
        Assertions.assertEquals(this.expected4, this.actual4, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected4);
        System.out.println("Фактическое значение: " + this.actual4);
    }
}