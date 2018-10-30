import base.BasePage;
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

    private By startButton = By.id("start");
    private By helloWordText = By.id("finish");

    public void openHelloWordText(){
        click(startButton);
    }

    public boolean isHelloWordDisplayed(){
        waitForElementToBeVisible(helloWordText);
        return isDisplayed(helloWordText);
    }
}
