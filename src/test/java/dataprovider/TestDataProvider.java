package dataprovider;

import driver.DriverBase;
import model.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Url;

public class TestDataProvider extends DriverBase {

    @Test(dataProvider = "loginData")
    public void login(String username, String password) {

        WebDriver driver = getDriver();
        driver.get(Url.currentTestUrl("LOGIN_PAGE"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("tomsmith")
                .inputPassword("SuperSecretPassword!")
                .submit();

    }

    @DataProvider
    public Object[][] loginData() {
        Object[][] loginData = new Object[2][2];
        loginData[0][0] = "tomsmith";
        loginData[0][1] = "123";
        loginData[1][0] = "tomsmith";
        loginData[1][1] = "SuperSecretPassword";
        return loginData;
    }
}

