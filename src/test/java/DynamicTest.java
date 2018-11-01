import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class DynamicTest extends SeleniumBase {
    @Test
    public void elementVisible(){
        DynamicLoadPage dynamicLoadPage = (DynamicLoadPage) new DynamicLoadPage().get();
        dynamicLoadPage.openHelloWordText();
        assertTrue(dynamicLoadPage.isHelloWordDisplayed(),"Element is not visible");
        assertEquals(dynamicLoadPage.getFinishText(),"Hello World!", "Is not displayed");

    }
}
