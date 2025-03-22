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

public class LinkTestAllure {
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
    @Description("Проверка работы ссылки на услуги связи на сайте МТС")
    @Severity(SeverityLevel.NORMAL)
    public void testLink() {
        openWebsite();
        acceptCookies();
        selectService();
        clickServiceDetailsLink();
        verifyPageTitle();
    }

    @Step("Открытие веб-сайта")
    private void openWebsite() {
        driver.get("https://www.mts.by/");
    }

    @Step("Принятие cookies")
    private void acceptCookies() {
        basePage.acceptCookies();
    }

    @Step("Выбор услуги")
    private void selectService() {
        basePage.selectService("Услуги связи");
    }

    @Step("Клик по ссылке с деталями услуги")
    private void clickServiceDetailsLink() {
        basePage.getServiceDetailsLink().click();
    }

    @Step("Проверка заголовка страницы")
    private void verifyPageTitle() {
        String pageTitle = driver.getTitle();
        Assertions.assertEquals(pageTitle, "Порядок оплаты и безопасность интернет платежей", "Ссылка не работает.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}