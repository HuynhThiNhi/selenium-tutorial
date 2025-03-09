package test;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class RightClickPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/context_menu");

        By rightClickPlace = By.id("hot-spot");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightClickPlace)).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

//         This is to refresh the page and remove the triggered context menu
        driver.navigate().refresh();

        // debug purpose only
        Thread.sleep(5000);

        driver.quit();
    }
}
