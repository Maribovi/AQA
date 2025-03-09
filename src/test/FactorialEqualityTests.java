import org.example.lesson_14_junit_5.Factorial;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FactorialEqualityTests {
    int expected = 720;
    int actual = Factorial.factorial(6);
    int expected1 = 1;
    int actual1 = Factorial.factorial(0);
    int expected2 = 1;
    int actual2 = Factorial.factorial(1);

    @Test
    public void testEqualityFactorial() {
        Assertions.assertEquals(this.expected, this.actual, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected);
        System.out.println("Фактическое значение: " + this.actual);
    }

    @Test
    public void testEqualityFactorial1() {
        Assertions.assertEquals(this.expected1, this.actual1, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected1);
        System.out.println("Фактическое значение: " + this.actual1);
    }

    @Test
    public void testEqualityFactorial2() {
        Assertions.assertEquals(this.expected2, this.actual2, "Ожидаемый результат не совпадает с фактическим");
        System.out.println("Ожидаемое значение: " + this.expected2);
        System.out.println("Фактическое значение: " + this.actual2);
    }
}