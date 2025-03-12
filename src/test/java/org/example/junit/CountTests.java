package org.example.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.lesson_14_junit_5.Count.count;

public class CountTests {

    @Test
    public void testCount() {
        Assertions.assertTrue(count(4, 5, '*') == 20, "Ожидаемый результат не совпадает с фактическим");
        Assertions.assertEquals(count(5, 5, '-'), 0, "Ожидаемый результат не совпадает с фактическим");
        Assertions.assertEquals(count(5, 0, '/'), 0);
        Assertions.assertEquals(count(5, -4, '+'), 1);
    }
}