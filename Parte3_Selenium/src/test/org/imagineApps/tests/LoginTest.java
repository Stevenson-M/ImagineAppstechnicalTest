package org.imagineApps.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.imagineApps.pages.LoginPage;
import org.imagineApps.pages.MainPage;
import org.imagineApps.pages.StorePage;

public class LoginTest extends BaseTest {


    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.goToStorePageButton();
        StorePage storePage = new StorePage(driver.getDriver());
        storePage.goToLoginPageButton();
        LoginPage loginPage = new LoginPage(driver.getDriver());
        loginPage.login(username, password);
        StorePage storePage1 = new StorePage(driver.getDriver());
        Assert.assertTrue(storePage1.checkWeAreBackInStorePage());
    }
}
