import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
private WebDriver driver;

    @Test
    public void successLogin(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Browser Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        assertTrue(driver.getCurrentUrl().contains("https://www.google.com"), "The page was not load correctly");


    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
