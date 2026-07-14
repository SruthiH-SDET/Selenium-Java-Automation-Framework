package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By addToCartButton = By.cssSelector("button[formaction*='cart.add']");
    private By cartTotal = By.id("header-cart");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void addFirstProductToCart() {
        WebElement button = driver.findElement(addToCartButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public String getCartText() {
        return driver.findElement(cartTotal).getText();
    }
}