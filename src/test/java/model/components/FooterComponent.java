package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent {
    private final WebDriver driver;

    private final By pageFooterSelector = By.cssSelector("#page-footer");
    private final By pageFooterLinkText = By.cssSelector("#page-footer a");

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageFooter() {
        return this.driver.findElement(this.pageFooterSelector);
    }

    public WebElement getPageFooterLinkText() {
        return this.driver.findElement(this.pageFooterLinkText);
    }
}
