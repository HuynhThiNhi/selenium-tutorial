package test;

import driver.DriverBase;
import driver.DriverFactory;
import driver.GridDriverBase;
import model.pages.LoginPage;
import model.pages.UserDashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Url;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

// purpose for running parallel
public class LoginTest2  extends GridDriverBase {

    @Test( groups = {"smoke"})
    @Parameters("browser")
    public void loginWithCorrectCredential(String browser) throws MalformedURLException {
        RemoteWebDriver driver = this.getDriver(browser);

        try {
            driver.get(Url.currentTestUrl("LOGIN_PAGE"));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("tomsmith")
                    .inputPassword("SuperSecretPassword!")
                    .submit();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/secure"));
            UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
            String expectedPageHeader = "Secure Area";

            String actualPageHeader = userDashboardPage.getPageHeaderSelector().getText();
            Assert.assertEquals(actualPageHeader, expectedPageHeader);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
