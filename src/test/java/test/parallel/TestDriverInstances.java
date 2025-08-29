package test.parallel;

import driver.DriverBase;
import model.pages.LoginPage;
import model.pages.UserDashboardPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Url;

import static org.testng.AssertJUnit.assertTrue;

public class TestDriverInstances extends DriverBase {

    @Test
    public void TestLogin() {
        WebDriver driver = getDriver();
//        Assert.fail();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("tomsmith1")
                .inputPassword("SuperSecretPassword!")
                .submit();
        UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
        assertTrue(userDashboardPage.getPageHeaderSelector().isDisplayed());
    }

    @Test
    public void TestLogin2() {
        WebDriver driver = getDriver();
//        Assert.fail();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("tomsmith1")
                .inputPassword("SuperSecretPassword!")
                .submit();
        UserDashboardPage dashboardPage = new UserDashboardPage(driver);
        assertTrue(dashboardPage.getLogoutBtnSelector().isDisplayed());
    }
}
