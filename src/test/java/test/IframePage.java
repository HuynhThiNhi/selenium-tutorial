package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/iframe");

        By iframeNodeSelector = By.id("mce_0_ifr");
        By iframeBodySelector = By.id("tinymce");

        WebElement iframeNode = driver.findElement(iframeNodeSelector);
        driver.switchTo().frame(iframeNode);

        WebElement iframeBody = driver.findElement(iframeBodySelector);
        iframeBody.clear();
        iframeBody.sendKeys("Hello Nhi");

        driver.switchTo().defaultContent();

        Thread.sleep(5000);
        driver.quit();

    }
}
