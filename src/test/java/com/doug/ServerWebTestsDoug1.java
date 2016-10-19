package com.doug;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DougStudyAppSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerWebTestsDoug1 {

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
    public void addBookToOneList() {
        String baseUrl = "http://localhost:" + port + "/login";
        browser.get(baseUrl);

        String currentUrl = browser.getCurrentUrl();
        assertEquals(baseUrl, currentUrl);

//        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)\n" +
//                        "DESCRIPTION",
//                browser.findElementByTagName("div").getText());

        browser.findElementByName("username").sendKeys("BOOK TITLE");
        browser.findElementByName("password").sendKeys("BOOK AUTHOR");

        browser.findElementByTagName("form").submit();

//        WebElement dl =
//                browser.findElementByCssSelector("dt.bookHeadline");
//        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)",
//                dl.getText());
//        WebElement dt =
//                browser.findElementByCssSelector("dd.bookDescription");
//        assertEquals("DESCRIPTION", dt.getText());
    }




    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }

}
