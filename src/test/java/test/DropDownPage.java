package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDownPage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropDown);
        options.selectByIndex(1);
        List<WebElement> optionsList = options.getOptions();

        // purpose on testing
        Thread.sleep(5000);

        driver.quit();

    }

}
