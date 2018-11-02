import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoadingTest extends SeleniumBase {
    @Test
    public void elementVisible(){
        LoadingPage loadingPage = (LoadingPage) new LoadingPage().get();
        loadingPage.openHelloWordText();
        assertTrue(loadingPage.isFinishTextDisplayed(),"Element is not visible");
        assertEquals(loadingPage.getFinishText(),"Hello World!", "Is not displayed");

    }
}
