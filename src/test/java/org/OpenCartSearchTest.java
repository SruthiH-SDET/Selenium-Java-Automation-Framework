package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OpenCartSearchTest {

    @Test
    public void searchForProduct() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharshan\\OneDrive - GP Strategies\\Documents\\Webdrivers\\chromedriver.exe.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demo.opencart.com");

        // Give the security check time to pass
        Thread.sleep(5000);

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("MacBook");

        WebElement searchButton = driver.findElement(By.cssSelector("#search button"));
        searchButton.click();

        List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));
        Assert.assertTrue(results.size() > 0, "Expected at least one search result, but found none.");

        driver.quit();
    }
}