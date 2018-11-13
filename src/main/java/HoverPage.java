import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HoverPage extends BasePage {
    @FindBys({
            @FindBy(css = ".figure")
    })
    private List<WebElement> figureElements;
    @FindBys({
            @FindBy(css = ".figcaption")
    })
    private List<WebElement> figcaptionElements;

    public HoverPage(){
        super();
        driver.get(getURL());
    }

    @Override
    public String getURL() {
        return "http://the-internet.herokuapp.com/hovers";
    }

    public void hoverElement(){
        getActions().moveToElement(figureElements.get(0)).build().perform();
    }

    public boolean isFooterDisplayed(){
        return isDisplayed(figcaptionElements.get(0));
    }

    public int getFigcaptionSize() {
        return figcaptionElements.size();
    }
}
