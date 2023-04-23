package org.imagineApps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StorePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement LoginPageButton;

    @FindBy(css = "div:nth-child(1) div:nth-child(3) div:nth-child(1) form:nth-child(1) > input:nth-child(1)")
    private WebElement searchInput;

    @FindBy(css = "div:nth-child(1) div:nth-child(3) div:nth-child(1) form:nth-child(1) > input:nth-child(2)")
    private WebElement searchButton;

    @FindBy(css = "div:nth-child(2) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(3)")
    private WebElement productNameSearchResult;



    public StorePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPageButton() {
        clickElement(LoginPageButton);
        return new LoginPage(getDriver());
    }

    public boolean checkWeAreBackInStorePage() {
        return getDriver().getCurrentUrl().contains("https://petstore.octoperf.com/actions/Account.action");
    }

    public boolean checkWeAreInProductSearchPage() {
        return getDriver().getCurrentUrl().contains("https://petstore.octoperf.com/actions/Catalog.action");
    }

    public boolean checkProductNameSearchResult() {
        return productNameSearchResult.getText().equals("Koi");
    }


    public void searchProduct(String product) {
        typeOnInput(searchInput, product);
        clickElement(searchButton);
    }
}
