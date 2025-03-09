package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHoverPage {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();

        By avatarSelector = By.cssSelector(".figure");
        By usernameSelector = By.cssSelector(".figcaption h5");
        By usernameHyperlink = By.cssSelector(".figcaption a");

        List<WebElement> avatars = driver.findElements(avatarSelector);
        List<WebElement> usernames = driver.findElements(usernameSelector);
        List<WebElement> usernameHyperlinks = driver.findElements(usernameHyperlink);

        // action
        Actions actions = new Actions(driver);
        actions.moveToElement(avatars.get(0)).perform();
        System.out.println(usernames.get(0).getText());
        System.out.println(usernameHyperlinks.get(0).getDomAttribute("href"));

        // user 2
        actions.moveToElement(avatars.get(1)).perform();
        System.out.println(usernames.get(1).getText());
        System.out.println(usernameHyperlinks.get(1).getDomAttribute("href"));

        // user 3
        actions.moveToElement(avatars.get(2)).perform();
        System.out.println(usernames.get(2).getText());
        System.out.println(usernameHyperlinks.get(2).getDomAttribute("href"));

        driver.quit();
    }
}
