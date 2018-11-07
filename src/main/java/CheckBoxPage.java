import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CheckBoxPage extends BasePage {

    @FindBys({
            @FindBy(css = "#checkboxes ")
    })
    private List<WebElement> checkboxes;

    public CheckBoxPage() {
        super();
        driver.get(getURL());
    }

    @Override
    public String getURL() {
        return "http://the-internet.herokuapp.com/checkboxes";
    }


    public boolean isCheckboxChecked(int index) {
        String attribute = checkboxes.get(index).getAttribute("checked");
        if (attribute != null){
            return Boolean.valueOf(attribute);
        }else {
            return false;
        }
    }
// Ete defolt chi

    public boolean isCheckBoxChecked(String text) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(text)) {
                String attribute = checkbox.getAttribute("checked");
                if (attribute != null) {
                    return Boolean.valueOf(attribute);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void ClickCheckbox(String text) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getText().equals(text)) {
                click(checkbox);
                break;
            }
        }
    }

    public boolean isCheckBoxCheckedWithSelected(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        click(checkboxes.get(index));
    }

}
