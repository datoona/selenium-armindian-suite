import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By signInButton = By.xpath("//*[@id=\"login\"]/button");
    private By successfullMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void loginWith(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public boolean isSuccessfullDisplayed() {
        return driver.findElement(successfullMessage).isDisplayed();
    }
}
