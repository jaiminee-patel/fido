package driverManager;

import configuration.FramworkConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager driverManager;



    private DriverManager() {

        if(FramworkConfig.getProperties("browser").equals(BrowserTypes.CHROME)){
            System.setProperty("webdriver.chrome.driver", FramworkConfig.getProperties("chrome.executable"));
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else
        if(FramworkConfig.getProperties("browser").equals(BrowserTypes.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", FramworkConfig.getProperties("firefox.executable"));
            driver=new FirefoxDriver();
        }
        else
        {
            System.setProperty("webdriver.chrome.driver", FramworkConfig.getProperties("chrome.executable"));
            driver=new ChromeDriver();
        }

    }

    public static WebDriver getDriverInstance()
    {
        if(driverManager==null){
            driverManager = new DriverManager();

        } return driverManager.driver;
    }
}
