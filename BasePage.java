package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void acceptCookies() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Принять']")));
            button.click();
        } catch (TimeoutException e) {
        }
    }

    public void selectService(String service) {
        WebElement dropdownElement = driver.findElement(By.id("pay"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(service);
    }

    public void fillConnectionDetails(String phone, String sum, String email) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(sum);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }

    public void submit() {
        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        submitButton.click();
    }

    public boolean isPaymentWidgetVisible() {
        WebElement paymentWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-app")));
        return paymentWidget.isDisplayed();
    }

    public WebElement getServiceDetailsLink() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Подробнее о сервисе']")));
    }

    public boolean isLogoDisplayed(String logoAlt) {
        try {
            WebElement logo = driver.findElement(By.cssSelector("img[alt='" + logoAlt + "']"));
            return logo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getBlockTitle() {
        WebElement block = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")));
        return block.getText();
    }

    public List<String> getPlaceholderTexts(String service) {
        switch (service) {
            case "Услуги связи":
                List<String> placeholders = new ArrayList<>();
                placeholders.add(driver.findElement(By.id("connection-phone")).getAttribute("placeholder"));
                placeholders.add(driver.findElement(By.id("connection-sum")).getAttribute("placeholder"));
                placeholders.add(driver.findElement(By.id("connection-email")).getAttribute("placeholder"));
                return placeholders;
            case "Домашний интернет":
                List<String> placeholders2 = new ArrayList<>();
                placeholders2.add(driver.findElement(By.id("internet-phone")).getAttribute("placeholder"));
                placeholders2.add(driver.findElement(By.id("internet-sum")).getAttribute("placeholder"));
                placeholders2.add(driver.findElement(By.id("internet-email")).getAttribute("placeholder"));
                return placeholders2;
            case "Рассрочка":
                List<String> placeholders3 = new ArrayList<>();
                placeholders3.add(driver.findElement(By.id("score-instalment")).getAttribute("placeholder"));
                placeholders3.add(driver.findElement(By.id("instalment-sum")).getAttribute("placeholder"));
                placeholders3.add(driver.findElement(By.id("instalment-email")).getAttribute("placeholder"));
                return placeholders3;
            case "Задолженность":
                List<String> placeholders4 = new ArrayList<>();
                placeholders4.add(driver.findElement(By.id("score-arrears")).getAttribute("placeholder"));
                placeholders4.add(driver.findElement(By.id("arrears-sum")).getAttribute("placeholder"));
                placeholders4.add(driver.findElement(By.id("arrears-email")).getAttribute("placeholder"));
                return placeholders4;
            default:
                throw new IllegalArgumentException("Unknown service: " + service);
        }
    }

    public List<String> getExpectedPlaceholders(String service) {
        switch (service) {
            case "Услуги связи":
                return Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
            case "Домашний интернет":
                return Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
            case "Рассрочка":
                return Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
            case "Задолженность":
                return Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");
            default:
                throw new IllegalArgumentException("Unknown service: " + service);
        }
    }

    public String getPaymentAmountText() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__cost span")));
        String amountText = amountElement.getText();
        return amountText;
    }

    public String getButtonText() {
        WebElement buttonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit' and contains(@class, 'colored') and contains(@class, 'disabled')]")));
        String buttonText = buttonElement.getText();
        return buttonText;
    }

    public String getPhoneNumberText() {
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Оплата: Услуги связи') and contains(text(), 'Номер:375297777777')]")));
        return phoneElement.getText();
    }

    public List<String> getCardFieldPlaceholderTexts() {
        List<String> cardFieldPlaceholders = new ArrayList<>();
        WebElement labelElement = driver.findElement(By.xpath("//label[text()='Номер карты']"));
        String labelText = labelElement.getText();
        cardFieldPlaceholders.add(labelText);
        WebElement labelElement2 = driver.findElement(By.xpath("//label[text()='Срок действия']"));
        String labelText2 = labelElement2.getText();
        cardFieldPlaceholders.add(labelText2);
        WebElement labelElement3 = driver.findElement(By.xpath("//label[text()='CVC']"));
        String labelText3 = labelElement3.getText();
        cardFieldPlaceholders.add(labelText3);
        WebElement labelElement4 = driver.findElement(By.xpath("//label[text()='Имя держателя (как на карте)']"));
        String labelText4 = labelElement4.getText();
        cardFieldPlaceholders.add(labelText4);
        return cardFieldPlaceholders;
    }

    public List<Boolean> arePaymentSystemIconsVisible() {
        List<Boolean> visibilityList = new ArrayList<>();
        String[] paymentIcons = {
                "img[src='assets/images/payment-icons/card-types/visa-system.svg']",
                "img[src='assets/images/payment-icons/card-types/mastercard-system.svg']",
                "img[src='assets/images/payment-icons/card-types/belkart-system.svg']",
                "img[src='assets/images/payment-icons/card-types/maestro-system.svg']"
        };

        for (String selector : paymentIcons) {
            try {
                WebElement image = driver.findElement(By.cssSelector(selector));
                visibilityList.add(image.isDisplayed());
            } catch (NoSuchElementException e) {
                visibilityList.add(false);
            }
        }
        return visibilityList;
    }
}