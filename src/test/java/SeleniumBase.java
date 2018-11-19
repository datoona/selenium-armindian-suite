import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;

import java.io.IOException;


public class SeleniumBase {
    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }

    //davetest@mailinator.com", "davetest"
    public void login(String email, String password) throws IOException {
        JsonObject loginJson = Client.login(email, password);
        JavascriptExecutor jse = (JavascriptExecutor) DriverHelper.get().getDriver();
        jse.executeScript("window.localStorage.setItem('token', '" + loginJson.get("auth_token") + "');");
        jse.executeScript("window.localStorage.setItem('userInfo', '" + loginJson + "');");
    }
}
