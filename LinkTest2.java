package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;

public class LinkTest2 {
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
    public void testLink() {
        driver.get("https://www.mts.by/");
        basePage.acceptCookies();
        basePage.selectService("Услуги связи");
        basePage.getServiceDetailsLink().click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Порядок оплаты и безопасность интернет платежей", "Ссылка не работает.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}