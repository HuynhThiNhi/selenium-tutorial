package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindow {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/windows");

        By clickHereLinkText = By.linkText("Click Here");
        WebElement linkTextElement = driver.findElement(clickHereLinkText);
        linkTextElement.click();

        List<String> windowsIds = new ArrayList<>(driver.getWindowHandles());
        for (String windowsId : windowsIds) {
            driver.switchTo().window(windowsId);
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            driver.close();
        }
    }
}
