package org.example.seleniumAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import java.util.List;

import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PlaceholdersTestAllure {
    private WebDriver driver;
    private BasePage basePage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
    }

    @Test
    @Description("Проверка отображения плейсхолдеров для различных услуг на сайте МТС")
    @Severity(SeverityLevel.NORMAL)
    public void testPlaceholders() {
        openWebsite();
        basePage.acceptCookies();

        checkServicePlaceholders("Услуги связи");
        checkServicePlaceholders("Домашний интернет");
        checkServicePlaceholders("Рассрочка");
        checkServicePlaceholders("Задолженность");
    }

    @Step("Открытие сайта МТС")
    private void openWebsite() {
        driver.get("https://www.mts.by/");
    }

    @Step("Проверка плейсхолдеров для услуги: {serviceName}")
    private void checkServicePlaceholders(String serviceName) {
        basePage.selectService(serviceName);
        List<String> placeholders = basePage.getPlaceholderTexts(serviceName);
        List<String> expectedPlaceholders = basePage.getExpectedPlaceholders(serviceName);
        Assert.assertEquals(placeholders, expectedPlaceholders, "Плейсхолдеры не совпадают для услуги: " + serviceName);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}