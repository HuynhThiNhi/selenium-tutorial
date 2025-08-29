package test;

import driver.DriverBase;
import driver.DriverFactory;
import model.pages.LoginPage;
import model.pages.UserDashboardPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Url;

import java.sql.Time;
import java.time.Duration;


public class LoginTest extends DriverBase {

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
////        DriverFactory.quitDriver();
////        this.driver.quit();
//    }
//
//    @AfterTest
//    public void tearDown() {
//        System.out.print("LoginTest: teardown");
//        DriverFactory.quitDriver();
//       // this.driver.quit();
//    }
//
//    @Test
//    public void register() {
//        System.out.print("Register success");
//    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"user1", "pass1"},
                {"tomsmith", "SuperSecretPassword!"}
        };
    }
  //  @Test(dependsOnMethods = {"register"}) // test dependencies
    @Test (dataProvider = "loginData", groups = {"smoke"}, description = "loginWithCorrectCredential")
    public void loginWithCorrectCredential(String username, String password) {
        WebDriver driver = getDriver();
        SoftAssert softAssert = new SoftAssert();
        try {

            driver.get(Url.currentTestUrl("LOGIN_PAGE"));

            LoginPage loginPage = new LoginPage(driver);
            loginPage.inputUsername(username)
                    .inputPassword(password)
                    .submit();
            softAssert.assertEquals(1,2);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/secure"));
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


            UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
            String expectedPageHeader = "Secure Area";
            String actualPageHeader = userDashboardPage.getPageHeaderSelector().getText();
            System.out.printf("actual: " + actualPageHeader);
            System.out.printf("expect: " + expectedPageHeader);
            Assert.assertEquals(actualPageHeader, expectedPageHeader);
        } catch (Exception e) {
//            DriverFactory.quitDriver(); // this e
            UserDashboardPage userDashboardPage = new UserDashboardPage(driver);
            String expectedPageHeader = "Secure Area";
            String actualPageHeader = userDashboardPage.getPageHeaderSelector().getText();
            System.out.printf("actual: " + actualPageHeader);
            System.out.printf("expect: " + expectedPageHeader);
            Assert.assertEquals(actualPageHeader, expectedPageHeader);
            e.printStackTrace();
        }





       // softAssert.assertAll();

    }

//    @Test(priority = 1)
//    public void testPriority() {
//
//    }
}
