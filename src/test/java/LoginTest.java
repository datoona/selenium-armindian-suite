import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver-windows-32bit.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void successLogin() {
        driver.get("https://www.google.com");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"), "The page was not load correctly");


    }

    @Test
    public void loginExample() throws InterruptedException {
       // driver.get("https://www.github.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");

        assertTrue(loginPage.isSuccessfullDisplayed(), "Error message is displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
