package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LinkTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLink() {
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
            button.click();
        } catch (TimeoutException e) {
        } finally {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Подробнее о сервисе']")));
            link.click();
            String pageTitle = driver.getTitle();
            Assert.assertEquals("Порядок оплаты и безопасность интернет платежей", pageTitle, "Ссылка не работает.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}