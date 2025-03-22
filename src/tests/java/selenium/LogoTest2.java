package tests.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class LogoTest2 {
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
    public void testLogos() {
        driver.get("https://www.mts.by/");
        basePage.acceptCookies();
        assertTrue(basePage.isLogoDisplayed("Visa"), "Логотип Visa не отображается");
        assertTrue(basePage.isLogoDisplayed("Verified By Visa"), "Логотип Verified By Visa не отображается");
        assertTrue(basePage.isLogoDisplayed("MasterCard"), "Логотип MasterCard не отображается");
        assertTrue(basePage.isLogoDisplayed("MasterCard Secure Code"), "Логотип MasterCard Secure Code не отображается");
        assertTrue(basePage.isLogoDisplayed("Белкарт"), "Логотип Белкарт не отображается");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}