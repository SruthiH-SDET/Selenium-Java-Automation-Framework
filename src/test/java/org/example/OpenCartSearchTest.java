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

    @Test
    public void addProductToCart() throws InterruptedException {
        Thread.sleep(5000); // wait for bot-detection check to clear

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchFor("MacBook");

        CartPage cartPage = new CartPage(driver);
        String cartBefore = cartPage.getCartText();

        cartPage.addFirstProductToCart();

        Thread.sleep(2000); // give the cart a moment to update

        String cartAfter = cartPage.getCartText();

        Assert.assertNotEquals(cartAfter, cartBefore,
                "Expected cart total to change after adding a product, but it stayed the same.");
    }
}