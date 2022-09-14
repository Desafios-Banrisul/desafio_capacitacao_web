package Framework.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class DriverManager {
    private static WebDriver driver;

    private static WebDriver getManagerDriver(TypeBrowser type){

        switch (type){

            case CHROME:

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:

                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito");
                firefoxOptions.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case IE:

                WebDriverManager.iedriver().setup();
                MutableCapabilities capabilities = new MutableCapabilities();
                capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.IE);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
                driver = new InternetExplorerDriver();
                break;

            case EDGE:

                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--window-size=1920,1080");
                break;

            case HEADLESS:

                WebDriverManager.chromedriver().setup();
                ChromeOptions headless = new ChromeOptions();
                headless.addArguments("--headless");
                headless.addArguments("--window-size=1366,768");
                driver = new ChromeDriver(headless);
                break;

            default:
                break;
        }

        return driver;
    }

    public static WebDriver getDriver(TypeBrowser type){
        if(driver == null){
            driver = getManagerDriver(type);
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
