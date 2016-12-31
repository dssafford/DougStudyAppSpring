package com.doug.selenium;

import com.doug.DougStudyAppSpringApplication;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DougStudyAppSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class SeleniumLearningWebTestsFireFox {


    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getAbsolutePath());

        browser= new FirefoxDriver();

        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void bookFirstTestRecorded() {
        String baseUrl = "http://booking.com";


        browser.get(baseUrl);


        browser.findElement(By.id("ss")).clear();
        browser.findElement(By.id("ss")).sendKeys("London");
        //browser.findElement(By.cssSelector("button.sb-searchbox__button.")).click();
        browser.findElement(By.cssSelector("div.sb-date-field__display")).click();
        browser.findElement(By.cssSelector("div.sb-date-field__display")).click();
        browser.findElement(By.xpath("//form[@id='frm']/div[4]/div/div/div/div[2]/div[2]/div[2]/div[3]/div/div/div/table/tbody/tr[5]/td[7]/span")).click();
        browser.findElement(By.xpath("//form[@id='frm']/div[4]/div/div/div[2]/div[2]/div/div/div[2]")).click();
        browser.findElement(By.cssSelector("td.c2-day.c2-day-s-hilighted")).click();
        new Select(browser.findElement(By.id("group_adults"))).selectByVisibleText("1");
        new Select(browser.findElement(By.id("group_children"))).selectByVisibleText("1");
        browser.findElement(By.cssSelector("#group_children > option[value=\"1\"]")).click();
        browser.findElement(By.name("age")).click();
        new Select(browser.findElement(By.name("age"))).selectByVisibleText("10");
        browser.findElement(By.cssSelector("select[name=\"age\"] > option[value=\"10\"]")).click();
        browser.findElement(By.xpath("//div[@id='filter_review']/div[2]/a[2]")).click();
        browser.findElement(By.cssSelector("button.sb-searchbox__button.")).click();



    }

    @Test
    public void SimpleDriverTest() {
        String baseUrl = "http://www.google.com";
        browser.get(baseUrl);
    }


    @Test
    public void loginSubmitGoodTestChrome() {
//        Ensure that we don't get an exception for good login
        Integer i = 0;

        String baseUrl = "http://localhost:" + port + "/login";

        browser.get(baseUrl);

        browser.findElementByName("username").sendKeys("doug");
        browser.findElementByName("password").sendKeys("password");


        //browser.findElementsByLinkText("Checkout").get(0).click();


        assertEquals("http://localhost:" + port + "/login", browser.getCurrentUrl());

        browser.findElementByTagName("form").submit();
        assertEquals(1,1);
        assertEquals("http://localhost:" + port + "/", browser.getCurrentUrl());


    }

    @Test
    public void differentWaysToUseDriverAndFindElements() {
        String baseUrl = "http://localhost:" + port + "/login";
        browser.get(baseUrl);

        String currentUrl = browser.getCurrentUrl();
        assertEquals(baseUrl, currentUrl);

        WebElement ds = browser.findElementsByClassName("formHeader").get(0);

        assertEquals("Please Login:", ds.getText());


        browser.findElementByName("username").sendKeys("doug");
        browser.findElementByName("password").sendKeys("password");

        browser.findElementByTagName("form").submit();


    }

//    @Test
//    public void findByCSSSelector() {
//
//        String baseUrl = "http://localhost:" + port + "/login";
//        browser.get(baseUrl);
//
//
//        WebElement dl =
//                browser.findElementByCssSelector("div.dougOne");
//        assertEquals("Hey You",
//                dl.getText());
//
//    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

}
