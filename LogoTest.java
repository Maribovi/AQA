package selenium;

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

import static org.testng.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LogoTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
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

            WebElement visaLogo = driver.findElement(By.cssSelector("img[alt='Visa']"));
            assertTrue(visaLogo.isDisplayed(), "Логотип Visa не отображается");

            WebElement verifiedByVisaLogo = driver.findElement(By.cssSelector("img[alt='Verified By Visa']"));
            assertTrue(verifiedByVisaLogo.isDisplayed(), "Логотип Verified By Visa не отображается");

            WebElement masterCardLogo = driver.findElement(By.cssSelector("img[alt='MasterCard']"));
            assertTrue(masterCardLogo.isDisplayed(), "Логотип MasterCard не отображается");

            WebElement masterCardSecureCodeLogo = driver.findElement(By.cssSelector("img[alt='MasterCard Secure Code']"));
            assertTrue(masterCardSecureCodeLogo.isDisplayed(), "Логотип MasterCard Secure Code не отображается");

            WebElement belkartLogo = driver.findElement(By.cssSelector("img[alt='Белкарт']"));
            assertTrue(belkartLogo.isDisplayed(), "Логотип Белкарт не отображается");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}