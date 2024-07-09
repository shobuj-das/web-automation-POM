package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverSetup {
    public static String browserName = System.getProperty("browser", "Chrome");
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return WEB_DRIVER_THREAD_LOCAL.get();
    }
    public static void setDriver(WebDriver driver){
        DriverSetup.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }
    public WebDriver getBrowser(String browserName) throws InterruptedException{
        if(browserName.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();
        else if (browserName.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else if(browserName.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();
        else
            throw new RuntimeException("Browser not found !!");
    }

    @BeforeSuite
    public void openABrowser() throws InterruptedException{
       WebDriver driver = getBrowser(browserName);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();
       setDriver(driver);
    }

    @AfterSuite
    public void closeBrowser() throws InterruptedException{
        getDriver().quit();
    }
}
