package org.imagineApps.pages.PageForAlertTest;

import org.imagineApps.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DemoblazeMainPage extends BasePage {

    @FindBy(css = ":nth-child(1) > .card > .card-block > .card-title > .hrefch")
    private org.openqa.selenium.WebElement Product1;

    public DemoblazeMainPage(WebDriver driver) {
        super(driver);
    }

    public DemoblazeProductPage goToProduct1() {
        clickElement(Product1);
        return new DemoblazeProductPage(getDriver());
    }
}
