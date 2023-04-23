package org.imagineApps.tests;

import org.imagineApps.pages.PageForAlertTest.DemoblazeMainPage;
import org.imagineApps.pages.PageForAlertTest.DemoblazeProductPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleAlertTest extends BaseTest {

    @Test
    @Parameters({"demoBlazeUrl"})
    public void handleAlertTest(String demoBlazeUrl) {
        driver.getDriver().get(demoBlazeUrl);
        DemoblazeMainPage demoblazeMainPage = new DemoblazeMainPage(driver.getDriver());
        demoblazeMainPage.goToProduct1();
        DemoblazeProductPage demoblazeProductPage = new DemoblazeProductPage(driver.getDriver());
        demoblazeProductPage.addToCart();
        demoblazeProductPage.switchToAlert();
        demoblazeProductPage.checkAlertText();
        demoblazeProductPage.acceptAlert();
    }
}
