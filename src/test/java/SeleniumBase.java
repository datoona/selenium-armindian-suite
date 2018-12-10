import api.Client;
import base.DriverHelper;
import com.google.gson.JsonObject;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;


public class SeleniumBase implements IHookable {
    private static final Logger LOGGER = Logger.getLogger("SeleniumBase");
    private static WebDriver driver = DriverHelper.get().getDriver();

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

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        iHookCallBack.runTestMethod(iTestResult);
        if (iTestResult.getThrowable() != null) {
            try {
                takeScreenshot(iTestResult.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenshot(String methodName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("./target/screenshots/" + methodName + ".png"));
        LOGGER.info("***TAKING a screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
