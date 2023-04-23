package org.imagineApps.tests;

import static java.lang.String.format;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import configuration.Driver;
import org.imagineApps.pages.MainPage;
import org.imagineApps.reporting.Reporter;
import org.testng.annotations.Parameters;

public class BaseTest {

    public Driver driver;
    protected MainPage mainPage;


    @BeforeTest()
    @Parameters({"browser", "url"})
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info(format("Navigating to %s", url));
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        mainPage = new MainPage(driver.getDriver());
    }

    @AfterTest
    public void tearDown() {
        Reporter.info("Closing browser");
        driver.getDriver().quit();
    }

}