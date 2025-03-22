package seleniumAllure;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

import java.util.List;

public class PlaceholdersTestAllure {
    private WebDriver driver;
    private BasePage basePage;

    @BeforeEach
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
        Assertions.assertEquals(placeholders, expectedPlaceholders, "Плейсхолдеры не совпадают для услуги: " + serviceName);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}