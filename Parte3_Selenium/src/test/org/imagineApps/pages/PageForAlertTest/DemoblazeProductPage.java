package org.imagineApps.pages.PageForAlertTest;

import org.imagineApps.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoblazeProductPage extends BasePage {

    @FindBy(css = ".col-sm-12 > .btn")
    private org.openqa.selenium.WebElement AddToCartButton;

    public DemoblazeProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        clickElement(AddToCartButton);
    }

    public void switchToAlert() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(webDriver -> webDriver.switchTo().alert());
    }

    public boolean checkAlertText() {
        return getDriver().switchTo().alert().getText().equals("Product added");
    }

    public void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

}
