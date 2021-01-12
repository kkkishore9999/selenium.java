package com.testproject;

import io.testproject.sdk.drivers.web.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleTest {

    private ChromeDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver("1Falx0J-mBFekfVfGokdgheHYLzgcQxWoqgeJ4OonCA1" ,new ChromeOptions(), "selenium.java");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCOpen3() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        assertEquals("Filling Out Forms - Ultimate QA", driver.getTitle());
    }

   @Test
    public void shouldAOpentandcLink1() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Terms and conditions")).click();
        System.out.println("Clicking done successfully");

    }


    @Test
    public void shouldBType2() throws InterruptedException {
        driver.navigate().to("https://ultimateqa.com/filling-out-forms/");
        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Krishna");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.name("et_builder_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        var actualListItems = driver.findElements(By.xpath("//*[@class='et-pb-contact-message']/ul/li")).size();
        assertEquals(1, actualListItems);
    }
}
