package com.doug;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DougStudyAppSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
    public void testContext() {
        assertEquals("one", "one");
    }

    @Test
    public void loginSubmitTest() {
        String baseUrl = "http://localhost:" + port + "/";
        browser.get(baseUrl);

//        browser.findElementByName("username").sendKeys("user");
//        browser.findElementByName("password").sendKeys("password");
        browser.findElementsByLinkText("Checkout").get(0).click();


        assertEquals("http://localhost:" + port + "/checkout", browser.getCurrentUrl());

        //browser.findElementByTagName("form").submit();


    }
    @Test
    public void differentWaysToUseDriverAndFindElements() {
        String baseUrl = "http://localhost:" + port + "/login";
        browser.get(baseUrl);

        String currentUrl = browser.getCurrentUrl();
        assertEquals(baseUrl, currentUrl);

        WebElement ds = browser.findElementsByClassName("shit").get(0);

        assertEquals("Wowser Mammie", ds.getText());


        browser.findElementByName("username").sendKeys("BOOK TITLE");
        browser.findElementByName("password").sendKeys("BOOK AUTHOR");

        browser.findElementByTagName("form").submit();

        WebElement dl =
                browser.findElementByCssSelector("dt.bookHeadline");
        assertEquals("Bookie by Baby (ISBN: booboo)",
                dl.getText());
        WebElement dt =
                browser.findElementByCssSelector("dd.bookDescription");
        assertEquals("mybook by eatshit", dt.getText());
    }




    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

}
