package tests.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.java.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ButtonTest2 {
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
    public void testButton() {
        driver.get("https://www.mts.by/");
        basePage.acceptCookies();
        basePage.selectService("Услуги связи");
        basePage.fillConnectionDetails("297777777", "100", "testmail@mail.ru");
        basePage.submit();
        assertTrue(basePage.isPaymentWidgetVisible(), "Платежный виджет не появился.");

        String expectedAmount = "100.00 BYN";
        String actualAmount = basePage.getPaymentAmountText();
        assertTrue(actualAmount.contains(expectedAmount), "Некорректная сумма на платёжном виджете: " + actualAmount);

        String expectedButtonText = "Оплатить 100.00 BYN";
        String actualButtonText = basePage.getButtonText();
        assertTrue(actualButtonText.contains(expectedButtonText), "Текст не соответствует. Найден: " + actualButtonText);

        String expectedPhoneNumber = "Оплата: Услуги связи Номер:375297777777";
        String actualPhoneNumber = basePage.getPhoneNumberText();
        assertTrue(actualPhoneNumber.equals(expectedPhoneNumber), "Некорректный номер телефона: " + actualPhoneNumber);

        List<String> actualCardFieldPlaceholders = basePage.getCardFieldPlaceholderTexts();
        List<String> expectedCardFieldPlaceholders = new ArrayList<>();
        expectedCardFieldPlaceholders.add("Номер карты");
        expectedCardFieldPlaceholders.add("Срок действия");
        expectedCardFieldPlaceholders.add("CVC");
        expectedCardFieldPlaceholders.add("Имя держателя (как на карте)");
        Assert.assertEquals(actualCardFieldPlaceholders, expectedCardFieldPlaceholders, "Некорректный плейсхолдер.");

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