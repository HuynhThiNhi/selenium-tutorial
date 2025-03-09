import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver chromeBrowser = DriverFactory.getDriver("chrome");
        chromeBrowser.get("https://www.google.com");
        chromeBrowser.quit();
    }   
}
