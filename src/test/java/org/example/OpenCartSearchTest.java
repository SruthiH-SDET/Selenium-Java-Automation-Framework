package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartSearchTest extends BaseTest {

    @Test
    public void searchForProduct() throws InterruptedException {
        Thread.sleep(5000); // wait for bot-detection check to clear

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFor("MacBook");

        Assert.assertTrue(searchPage.getSearchResults().size() > 0,
                "Expected at least one search result, but found none.");
    }
}