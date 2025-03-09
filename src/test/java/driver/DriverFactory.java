package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "ie": {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
            case "safari": {
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            }
            default: {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
    }
}
