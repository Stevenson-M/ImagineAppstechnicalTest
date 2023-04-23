package org.imagineApps.tests;

import org.imagineApps.pages.MainPage;
import org.imagineApps.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class SearchProductTest extends BaseTest {

    @Test
    @Parameters({"productSearched"})
    public void searchProductTest(String productSearched) {
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.goToStorePageButton();
        StorePage storePage = new StorePage(driver.getDriver());
        storePage.searchProduct(productSearched);
        Assert.assertTrue(storePage.checkWeAreInProductSearchPage());
        Assert.assertTrue(storePage.checkProductNameSearchResult());
    }
}
