package org.example.seleniumAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ButtonTestAllure {
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
    @Description("Проверка работы кнопки и платежного виджета на сайте МТС")
    @Severity(SeverityLevel.NORMAL)
    public void testButton() {
        openWebsite();
        acceptCookies();
        selectService();
        fillConnectionDetails();
        assertPaymentWidgetVisible();
        assertPaymentAmount();
        assertButtonText();
        assertPhoneNumber();
        assertCardFieldPlaceholders();
        assertPaymentSystemIconsVisibility();
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

    @Step("Заполнение деталей подключения")
    private void fillConnectionDetails() {
        basePage.fillConnectionDetails("297777777", "100", "testmail@mail.ru");
        basePage.submit();
    }

    @Step("Проверка видимости платежного виджета")
    private void assertPaymentWidgetVisible() {
        assertTrue(basePage.isPaymentWidgetVisible(), "Платежный виджет не появился.");
    }

    @Step("Проверка суммы на платежном виджете")
    private void assertPaymentAmount() {
        String expectedAmount = "100.00 BYN";
        String actualAmount = basePage.getPaymentAmountText();
        assertTrue(actualAmount.contains(expectedAmount), "Некорректная сумма на платёжном виджете: " + actualAmount);
    }

    @Step("Проверка текста кнопки")
    private void assertButtonText() {
        String expectedButtonText = "Оплатить 100.00 BYN";
        String actualButtonText = basePage.getButtonText();
        assertTrue(actualButtonText.contains(expectedButtonText), "Текст не соответствует. Найден: " + actualButtonText);
    }

    @Step("Проверка номера телефона")
    private void assertPhoneNumber() {
        String expectedPhoneNumber = "Оплата: Услуги связи Номер:375297777777";
        String actualPhoneNumber = basePage.getPhoneNumberText();
        assertTrue(actualPhoneNumber.equals(expectedPhoneNumber), "Некорректный номер телефона: " + actualPhoneNumber);
    }

    @Step("Проверка плейсхолдеров полей карты")
    private void assertCardFieldPlaceholders() {
        List<String> actualCardFieldPlaceholders = basePage.getCardFieldPlaceholderTexts();
        List<String> expectedCardFieldPlaceholders = new ArrayList<>();
        expectedCardFieldPlaceholders.add("Номер карты");
        expectedCardFieldPlaceholders.add("Срок действия");
        expectedCardFieldPlaceholders.add("CVC");
        expectedCardFieldPlaceholders.add("Имя держателя (как на карте)");
        Assert.assertEquals(actualCardFieldPlaceholders, expectedCardFieldPlaceholders, "Некорректный плейсхолдер.");
    }

    @Step("Проверка видимости иконок платежных систем")
    private void assertPaymentSystemIconsVisibility() {
        List<Boolean> actualVisibilityList = new ArrayList<>();
        actualVisibilityList.add(true);
        actualVisibilityList.add(true);
        actualVisibilityList.add(true);
        actualVisibilityList.add(true);
        Assert.assertEquals(basePage.arePaymentSystemIconsVisible(), actualVisibilityList);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}