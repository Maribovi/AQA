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

public class NameTestAllure {
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
    @Description("Проверка названия блока на главной странице МТС")
    @Severity(SeverityLevel.NORMAL)
    public void testBlockTitle() {
        openWebsite();
        verifyBlockTitle();
    }

    @Step("Открытие веб-сайта")
    private void openWebsite() {
        driver.get("https://www.mts.by/");
    }

    @Step("Проверка названия блока")
    private void verifyBlockTitle() {
        String blockTitle = basePage.getBlockTitle();
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assertions.assertEquals(blockTitle, expectedTitle, "Название блока не совпадает с ожидаемым");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}