package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory2 {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (null == this.webDriver) {
            this.webDriver = DriverFactory.getDriver("chrome");

        }
        return this.webDriver;
    }

    public void quitDriver() {
        this.webDriver.quit();
    }
}
