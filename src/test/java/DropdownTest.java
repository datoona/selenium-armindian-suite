import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest extends SeleniumBase{

    @BeforeMethod
    public void setup(){

    }

    @Test
    public void dropdwon(){
        DropdownPage dropdownPage = new DropdownPage();
        dropdownPage.selectOptionCustom("Option 1");
    }
}
