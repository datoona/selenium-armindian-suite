import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//*[@id=\"login\"]/button");
    private By successfullMessage = By.id("flash");

    public LoginPage() {
        super();
        driver.get(getURL());
    }

    public String getURL() {
        return "https://the-internet.herokuapp.com/login";
    }

    public void loginWith(String username, String password) {
        type(userNameField, username);
        type(passwordField, password);
        click(signInButton);
    }

    public boolean isSuccessfullDisplayed() {
        return driver.findElement(successfullMessage).isDisplayed();
    }


}
