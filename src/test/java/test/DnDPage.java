package test;

import driver.DriverFactory;
import element.ElementController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class DnDPage {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver webDriver = DriverFactory.getDriver("chrome");
        webDriver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement leftColumnElem = webDriver.findElement(By.id("column-a"));
        WebElement rightColumnElem = webDriver.findElement(By.id("column-b"));

        ElementController.dnd(leftColumnElem, rightColumnElem);
        Thread.sleep(1000);
//        ElementController.dnd(rightColumnElem, leftColumnElem);

        webDriver.quit();
    }
}
