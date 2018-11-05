import org.testng.annotations.Test;

public class CheckBoxesTest extends SeleniumBase {

    @Test
    public void checkboxes(){
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.isCheckBoxCheked(0);
    }
}
