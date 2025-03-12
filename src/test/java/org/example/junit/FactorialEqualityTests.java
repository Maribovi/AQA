package org.example.junit;

import org.example.lesson_14_junit_5.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialEqualityTests {

    @Test
    public void testEqualityFactorial() {
        int expected = 720;
        int actual = Factorial.factorial(6);
        Assert.assertEquals(actual, expected, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected);
        System.out.println("Фактическое значение: " + actual);
    }

    @Test
    public void testEqualityFactorial1() {
        int expected1 = 1;
        int actual1 = Factorial.factorial(0);
        Assert.assertEquals(actual1, expected1, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected1);
        System.out.println("Фактическое значение: " + actual1);
    }

    @Test
    public void testEqualityFactorial2() {
        int expected2 = 1;
        int actual2 = Factorial.factorial(1);
        Assert.assertEquals(actual2, expected2, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + expected2);
        System.out.println("Фактическое значение: " + actual2);
    }
}