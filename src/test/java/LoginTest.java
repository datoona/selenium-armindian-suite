import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browser Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void successLogin() {
        driver.get("https://www.google.com");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"), "The page was not load correctly");


    }

    @Test
    public void githubFailedLogin() throws InterruptedException {
        driver.get("https://www.github.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("test@test.com", "test");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
