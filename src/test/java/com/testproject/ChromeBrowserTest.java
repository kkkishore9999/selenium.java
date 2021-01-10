package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeBrowserTest {

    private ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver("1Falx0J-mBFekfVfGokdgheHYLzgcQxWoqgeJ4OonCA1" ,new ChromeOptions(), "selenium.java");
        driver.get("https://example.cypress.io/commands/actions");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldOpen() {
        Assert.assertEquals("Cypress.io: Kitchen Sink", driver.getTitle());
    }

    @Test
    public void shouldType() {
        driver.get("https://example.cypress.io/commands/actions");
        var inputField = driver.findElement(By.cssSelector(".action-email"));
        inputField.sendKeys("test@test.com");
        Assert.assertEquals("test@test.com",
                inputField.getAttribute("value"));
    }
}
