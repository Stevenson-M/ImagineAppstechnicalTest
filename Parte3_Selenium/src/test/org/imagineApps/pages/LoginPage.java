package org.imagineApps.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/p[2]/input[1]")
    private WebElement usernameInput;

    @FindBy(css = "input[value='j2ee']")
    private WebElement passwordInput;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/form[1]/input[1]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        typeOnInput(usernameInput, username);
        typeOnInput(passwordInput, password);
        clickElement(loginButton);
    }



}
