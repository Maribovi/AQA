package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogos() {
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
            button.click();
        } catch (TimeoutException e) {
        } finally {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement block = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Visa']")));
            WebElement block1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Verified By Visa']")));
            WebElement block2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='MasterCard']")));
            WebElement block3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='MasterCard Secure Code']")));
            WebElement block4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Белкарт']")));
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}