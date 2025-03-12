package org.example.junit;

import org.example.lesson_14_junit_5.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialExceptionTest {
    @Test
    public void testFactorialOfNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-10));
        System.out.println("Для отрицательного числа выброшено исключение IllegalArgumentException");
    }
}