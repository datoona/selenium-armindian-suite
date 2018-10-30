package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver",
                    "./sgetrc/main/resources/drivers/chromedriver-windows-32bit.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
