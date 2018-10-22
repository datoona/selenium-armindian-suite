import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @Test
    public void successLogin() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browser Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"), "The page was not load correctly");


    }

    @Test
    public void githubFailedLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browser Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.github.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("test@test.com","test");
        
        assertTrue(loginPage.isErrorMessageDisplayed(),"Error message is displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
