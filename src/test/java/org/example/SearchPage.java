package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("#search button");
    private By resultItems = By.cssSelector(".product-thumb");

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchFor(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(resultItems);
    }
}