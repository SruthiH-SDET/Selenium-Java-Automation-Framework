package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTitleTest {

    @Test
    public void checkGoogleTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharshan\\OneDrive - GP Strategies\\Documents\\Webdrivers\\chromedriver.exe.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Google");

        driver.quit();
    }
}