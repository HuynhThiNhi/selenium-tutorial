package model.pages;

import model.components.FooterComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private final By userNameSelector = By.id("username") ;
    private final By passwordSelector = By.id("password");
    private final By loginBtnSelector = By.cssSelector("[type='submit']");

    private final FooterComponent footerComponent;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.footerComponent = new FooterComponent(driver);
    }

    public FooterComponent footerComponent() {
        return this.footerComponent;
    }

    public LoginPage inputUsername(String userName) {
        this.driver.findElement(this.userNameSelector).sendKeys(userName);
        return this;
    }

    public LoginPage inputPassword(String userName) {
        this.driver.findElement(this.userNameSelector).sendKeys(userName);
        return this;
    }

    public LoginPage submit() {
        this.driver.findElement(this.loginBtnSelector).submit();
        return this; // instead the next page after submitting
    }
}
