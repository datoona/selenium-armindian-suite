import org.testng.annotations.Test;

import java.io.IOException;

public class TaigaLoginTest extends SeleniumBase {
    @Test
    public void loginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        login("davetest@mailinator.com","davetest");
        new TaigaLoginPage();

    }

}
