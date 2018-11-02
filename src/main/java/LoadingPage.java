import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import static base.WaitHelper.waitForElementToBeVisible;


public class LoadingPage extends BasePage {

    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(css = "#finish h4")
    private WebElement finishText;

    public LoadingPage(){
        super();
        driver.get(getURL());
    }

    @Override
    public String getURL() {
        return "http://the-internet.herokuapp.com/dynamic_loading/1";
    }

    public void openHelloWordText(){
        click(startButton);
        WaitHelper.getWait().waitForElementToBeVisible(finishText);
    }

    public String getFinishText(){
        return finishText.getText();
    }
    public boolean isFinishTextDisplayed() {
        return isDisplayed(finishText);
    }

    @Override
    public void isLoaded(){
        WaitHelper.getWait().waitForElementToBeVisible(startButton);
    }
}
