package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.lesson_14_junit_5.CompareNumbers.compare;

public class CompareNumbersTestng {

    @Test
    public void compareNumbers() {
        Assert.assertEquals(compare(1, 10), "Первое число меньше второго.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(1, 10));

        Assert.assertEquals(compare(11, 2), "Первое число больше второго.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(11, 2));

        Assert.assertEquals(compare(0, 0), "Оба числа равны.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(0, 0));

        Assert.assertNotEquals(compare(-1, 0), "Оба числа равны.", "Ожидаемый результат не совпадает с фактическим");
        System.out.println(compare(-1, 0));
    }

    @Test(description = "Тест с отрицательным результатом")
    public void compareNegative() {
        Assert.assertEquals(compare(-1, 0), "Оба числа равны.", "Ожидаемый результат не совпадает с фактическим");
    }
}