import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.By;

import static base.WaitHelper.waitForElementToBeVisible;


public class DynamicLoadPage extends BasePage {

    public DynamicLoadPage(){
        super();
        driver.get(getURL());
    }

    @Override
    public String getURL() {
        return "http://the-internet.herokuapp.com/dynamic_loading/1";
    }

    private By startButton = By.cssSelector("#start button");
    private By helloWordText = By.cssSelector("#finish h4");

    public void openHelloWordText(){
        click(startButton);
        WaitHelper.getWait().waitForElementToBeVisible(helloWordText);
    }

    public String getFinishText(){
        return find(helloWordText).getText();
    }
    public boolean isHelloWordDisplayed(){
        return isDisplayed(helloWordText);
    }

    @Override
    public void isLoaded(){
        WaitHelper.getWait().waitForElementToBeVisible(startButton);
    }
}
