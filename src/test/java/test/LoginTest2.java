package test;

import driver.DriverFactory;
import model.pages.LoginPage;
import model.pages.UserDashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Url;

import java.time.Duration;

// purpose for running parallel
public class LoginTest2 {
//    @BeforeTest
//    public void setup() {
//        System.out.print("LoginTest: running setup data");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.print("LoginTest: before method");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.print("LoginTest: after method");
//        DriverFactory.quitDriver();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        System.out.print("LoginTest: teardown");
//        DriverFactory.quitDriver();
//       // this.driver.quit();
//
//    }
//
//    @Test
//    public void register() {
//        System.out.print("Register success");
//    }

   // @Test(dependsOnMethods = {"register"}) // test dependencies
    @Test
    public void loginWithCorrectCredential() {
        WebDriver driver = DriverFactory.getDriver("chrome");
        SoftAssert softAssert = new SoftAssert();
        try {
            driver.get(Url.currentTestUrl("LOGIN_PAGE"));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername("tomsmith")
                    .inputPassword("SuperSecretPassword!")
                    .submit();
            softAssert.assertEquals(1,2);
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/secure"));
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
            String expectedPageHeader = "Secure Area";

            String actualPageHeader = userDashboardPage.getPageHeaderSelector().getText();
            Assert.assertEquals(actualPageHeader, expectedPageHeader);
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
//            DriverFactory.quitDriver(); // this e
            driver.quit();
        }

        // softAssert.assertAll();

    }

//    @Test(priority = 1)
//    public void testPriority() {
//
//    }
}
