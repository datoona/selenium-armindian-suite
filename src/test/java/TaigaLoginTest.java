import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

public class TaigaLoginTest extends SeleniumBase {
    @Test
    public void loginViaApi() throws IOException {
        TaigaLoginPage taigaLoginPage = new TaigaLoginPage();
        JsonObject loginJson = Client.login("davetest@mailinator.com", "davetest");
        JavascriptExecutor jse = (JavascriptExecutor) DriverHelper.get().getDriver();
        jse.executeScript("window.localStorage.setItem('token', '" + loginJson.get("auth_token") + "');");
        jse.executeScript("window.localStorage.setItem('userInfo', '" + loginJson + "');");

        new TaigaLoginPage();

    }

}
