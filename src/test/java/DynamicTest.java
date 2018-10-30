import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class DynamicTest extends SeleniumBase {
    @Test
    public void elementVisible(){
        DynamicLoadPage dynamicLoadPage = new DynamicLoadPage();
        dynamicLoadPage.openHelloWordText();
        assertTrue(dynamicLoadPage.isHelloWordDisplayed(),"Element is not visible");

    }
}
