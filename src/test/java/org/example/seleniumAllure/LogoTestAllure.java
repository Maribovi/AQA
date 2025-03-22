package org.example.seleniumAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LogoTestAllure {
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
    @Description("Проверка отображения логотипов платежных систем на сайте МТС")
    @Severity(SeverityLevel.NORMAL)
    public void testLogos() {
        openWebsite();
        acceptCookies();
        checkLogos();
    }

    @Step("Открытие веб-сайта")
    private void openWebsite() {
        driver.get("https://www.mts.by/");
    }

    @Step("Принятие cookies")
    private void acceptCookies() {
        basePage.acceptCookies();
    }

    @Step("Проверка отображения логотипов")
    private void checkLogos() {
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