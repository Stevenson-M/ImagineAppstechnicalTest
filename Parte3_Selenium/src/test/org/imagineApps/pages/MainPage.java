package org.imagineApps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = "a[href='actions/Catalog.action']")
    private WebElement StorePageButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public StorePage goToStorePageButton() {
        clickElement(StorePageButton);
        return new StorePage(getDriver());
    }


}
