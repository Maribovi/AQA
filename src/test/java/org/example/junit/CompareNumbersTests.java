package org.example.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.lesson_14_junit_5.CompareNumbers.compare;

public class CompareNumbersTests {
    @Test
    public void compareNumbers() {
        Assertions.assertEquals(compare(1, 10), "Первое число меньше второго.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(1, 10));
        Assertions.assertEquals(compare(11, 2), "Первое число больше второго.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(11, 2));
        Assertions.assertEquals(compare(0, 0), "Оба числа равны.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(0, 0));
        Assertions.assertNotEquals("Оба числа равны.", compare(-1, 0));
        System.out.println(compare(-1, 0));
    }

    @Test
    @DisplayName("Тест с отрицательным результатом")
    public void compareNegative() {
        Assertions.assertEquals(compare(-1, 0), "Оба числа равны.", "Ожидаемый результат не совпадает с фактическим");
    }
}