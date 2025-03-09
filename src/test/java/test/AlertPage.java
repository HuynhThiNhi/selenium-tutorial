package test;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver("chrome");

        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
            final By jsAlertBtnSelector = By.cssSelector("[onclick=\"jsAlert()\"]");
            final By jsConfirmBtnSelector = By.cssSelector("[onclick=\"jsConfirm()\"]");
            final By jsPromptBtnSelector = By.cssSelector("[onclick=\"jsPrompt()\"]");
            final By result = By.id("result");

            driver.findElement(jsAlertBtnSelector).click();

            /*
             * get error when run this line:
             * System.out.println(driver.findElement(jsAlertBtnSelector).getText());
             * because at line 25, alert's opening
            * */
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.printf(alert.getText());

            // close alert
            alert.accept();
            System.out.printf(driver.findElement(result).getText());

            // play with js confirm alert
            driver.findElement(jsConfirmBtnSelector).click();
            Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(confirmAlert.getText());

            confirmAlert.dismiss();

            // play with js prompt alert
            driver.findElement(jsPromptBtnSelector).click();
            Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

            promptAlert.sendKeys("ok");
            promptAlert.accept();
            System.out.println("result: " + driver.findElement(result).getText());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
