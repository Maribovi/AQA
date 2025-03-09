package testng;

import org.example.lesson_14_junit_5.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialExceptionTestng {

    @Test
    public void testFactorialOfNegativeNumber() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-10));
        System.out.println("Для отрицательного числа выброшено исключение IllegalArgumentException");
    }
}