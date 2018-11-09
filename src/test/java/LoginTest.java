import base.DriverHelper;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends SeleniumBase {

    @Test
    public void successLogin() {
        DriverHelper.get().getDriver().get("https://www.google.com");
        assertTrue(DriverHelper.get().getDriver().getCurrentUrl().contains("https://www.google.com"), "The page was not load correctly");


    }

    @Test
    public void loginExample() throws InterruptedException {
       // driver.get("https://www.github.com/login");
        LoginPage loginPage = new LoginPage();
        loginPage.loginWith("tomsmith", "SuperSecretPassword!");
        assertTrue(loginPage.isSuccessfullDisplayed(), "Error message is displayed");
    }

}
