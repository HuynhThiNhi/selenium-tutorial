package model.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDashboardPage {
    final private WebDriver driver;
    final private By flashMessageSelector = By.id("flash");
    final private By pageHeaderSelector = By.tagName("h2");
    final private By subHeaderSelector = By.className("subheader");
    final private By logoutBtnSelector = By.cssSelector(".example a");


    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getFlashMessageSelector() {
        return this.driver.findElement(this.flashMessageSelector);
    }

    public WebElement getPageHeaderSelector() {
        return this.driver.findElement(this.pageHeaderSelector);
    }

    public WebElement getSubHeaderSelector() {
        return this.driver.findElement(this.subHeaderSelector);
    }

    public WebElement getLogoutBtnSelector() {
        return this.driver.findElement(this.logoutBtnSelector);
    }
}
