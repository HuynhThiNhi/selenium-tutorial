package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridDriverFactory {
    private RemoteWebDriver webDriver;
    public RemoteWebDriver getDriver(String browser) throws MalformedURLException {
        if (null != this.webDriver) {
            return this.webDriver;
        }
        switch (browser) {
            case "chrome": {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");      // important for Chrome 111+
                this.webDriver = new RemoteWebDriver(
                        new URL("http://localhost:4444"),
                        options
                );
                break;
            }
            case "firefox": {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-headless");  // headless required in containers
                this.webDriver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

        }
        return this.webDriver;
    }

    public void quitDriver() {
        this.webDriver.quit();
    }

}
