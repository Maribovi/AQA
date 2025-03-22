package seleniumAllure;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoTestAllure {
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}