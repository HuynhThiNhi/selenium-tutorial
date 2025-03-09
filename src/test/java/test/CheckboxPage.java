package test;

import driver.DriverFactory;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckboxPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver chrome = DriverFactory.getDriver("chrome");

        chrome.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = chrome.findElements(By.cssSelector("input[type=checkbox"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // for debug
        Thread.sleep(4000);
        chrome.quit();
    }
}
