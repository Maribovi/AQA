package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.lesson_14_junit_5.Count.count;

public class CountTestng {

    @Test
    public void testCount() {
        Assert.assertTrue(count(4, 5, '*') == 20, "Ожидаемый результат не совпадает с фактическим");
        Assert.assertEquals(count(5, 5, '-'), 0, "Ожидаемый результат не совпадает с фактическим");
        Assert.assertEquals(count(5, 0, '/'), 0);
        Assert.assertEquals(count(5, -4, '+'), 1);
    }
}