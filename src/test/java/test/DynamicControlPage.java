package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlPage {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        By removeBtnSelector = By.cssSelector("#checkbox-example button");
        By checkboxSelector = By.cssSelector("#checkbox");
        By inputSelector = By.cssSelector("#input-example button");
        By msgSelector = By.cssSelector("#message");

        driver.findElement(removeBtnSelector).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkboxSelector));
        System.out.println(driver.findElement(msgSelector).getText());

        driver.findElement(inputSelector).click();
        wait.until(ExpectedConditions.textToBe(inputSelector, "Disable"));
        driver.quit();
    }
}
