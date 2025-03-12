package org.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ButtonTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
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
            WebElement dropdownElement = driver.findElement(By.id("pay"));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Услуги связи");

            WebElement inputField1 = driver.findElement(By.id("connection-phone"));
            inputField1.sendKeys("297777777");

            WebElement inputField2 = driver.findElement(By.id("connection-sum"));
            inputField2.sendKeys("100");

            WebElement inputField3 = driver.findElement(By.id("connection-email"));
            inputField3.sendKeys("testmail@mail.ru");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
            submitButton.click();

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement paymentWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-app")));
            if (paymentWidget.isDisplayed()) {
                System.out.println("Платежный виджет появился на странице.");
            } else {
                System.out.println("Платежный виджет не появился.");
            }
        }
    }

        @AfterClass
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
    }