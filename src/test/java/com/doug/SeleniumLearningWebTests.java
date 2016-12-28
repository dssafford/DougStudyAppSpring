package com.doug;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DougStudyAppSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class SeleniumLearningWebTests {

    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void openBrowser() {
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginSubmitGoodTest() {
//        Ensure that we don't get an exception for good login
        String baseUrl = "http://localhost:" + port + "/login";
        browser.get(baseUrl);

        browser.findElementByName("username").sendKeys("doug");
        browser.findElementByName("password").sendKeys("password");


        //browser.findElementsByLinkText("Checkout").get(0).click();


        assertEquals("http://localhost:" + port + "/login", browser.getCurrentUrl());

        browser.findElementByTagName("form").submit();

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

    @Test
    public void findByCSSSelector() {

        String baseUrl = "http://localhost:" + port + "/login";
        browser.get(baseUrl);


        WebElement dl =
                browser.findElementByCssSelector("div.dougOne");
        assertEquals("Hey You",
                dl.getText());

    }

    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

}
