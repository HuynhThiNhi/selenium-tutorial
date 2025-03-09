package test;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) {
        WebDriver chrome = DriverFactory.getDriver("chrome");
//        implicit wait
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        chrome.get("https://the-internet.herokuapp.com/login");

        // explicit wait
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(10));
        WebElement userElement = wait.until(ExpectedConditions.visibilityOf(chrome.findElement(By.id("username1"))));

        // fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<>(chrome)
                .withTimeout(Duration.ofSeconds(10))  // Tổng thời gian chờ
                .pollingEvery(Duration.ofMillis(300)) // Kiểm tra lại mỗi 300ms
                .ignoring(NoSuchElementException.class); // Bỏ qua lỗi nếu phần tử chưa xuất hiện

        WebElement passwordElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
//        WebElement passwordElement = chrome.findElement(By.id("password"));
        WebElement loginButton = chrome.findElement(By.cssSelector("button[type=submit]"));

        userElement.sendKeys("teo");
        passwordElement.sendKeys("teo");
        loginButton.click();

        chrome.quit();
    }
}
