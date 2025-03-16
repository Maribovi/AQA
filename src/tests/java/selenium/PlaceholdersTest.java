package tests.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import java.util.List;

public class PlaceholdersTest {
    private WebDriver driver;
    private BasePage basePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
    }

    @Test
    public void testPlaceholders() {
        driver.get("https://www.mts.by/");
        basePage.acceptCookies();

        String service = "Услуги связи";
        String service2 = "Домашний интернет";
        String service3 = "Рассрочка";
        String service4 = "Задолженность";

        basePage.selectService(service);
        List<String> placeholder = basePage.getPlaceholderTexts(service);
        List<String> expectedPlaceholders = basePage.getExpectedPlaceholders(service);
        Assert.assertEquals(placeholder, expectedPlaceholders);

        basePage.selectService(service2);
        List<String> placeholder2 = basePage.getPlaceholderTexts(service2);
        List<String> expectedPlaceholders2 = basePage.getExpectedPlaceholders(service2);
        Assert.assertEquals(placeholder2, expectedPlaceholders2);

        basePage.selectService(service3);
        List<String> placeholder3 = basePage.getPlaceholderTexts(service3);
        List<String> expectedPlaceholders3 = basePage.getExpectedPlaceholders(service3);
        Assert.assertEquals(placeholder3, expectedPlaceholders3);

        basePage.selectService(service4);
        List<String> placeholder4 = basePage.getPlaceholderTexts(service4);
        List<String> expectedPlaceholders4 = basePage.getExpectedPlaceholders(service4);
        Assert.assertEquals(placeholder4, expectedPlaceholders4);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}