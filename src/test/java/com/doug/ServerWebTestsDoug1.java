package com.doug;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=DougStudyAppSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerWebTestsDoug1 {

    private static FirefoxDriver browser;

    @Value("${local.server.port}")
    private int port;

//    @BeforeClass
//    public static void openBrowser() {
//        browser = new FirefoxDriver();
//        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }

    @Test
    public void testContext() {
        Assert.assertEquals("one", "one");
    }

//    @Test
//    public void addBookToOneList() {
//        String baseUrl = "http://localhost:" + port;
//        browser.get(baseUrl);
//
//        String currentUrl = browser.getCurrentUrl();
//        assertEquals(baseUrl +"/readingList", currentUrl);
//
//        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)\n" +
//                        "DESCRIPTION",
//                browser.findElementByTagName("div").getText());
//
//        browser.findElementByName("title").sendKeys("BOOK TITLE");
//        browser.findElementByName("author").sendKeys("BOOK AUTHOR");
//        browser.findElementByName("isbn").sendKeys("1234567890");
//        browser.findElementByName("description").sendKeys("DESCRIPTION");
//        browser.findElementByTagName("form").submit();
//
//        WebElement dl =
//                browser.findElementByCssSelector("dt.bookHeadline");
//        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)",
//                dl.getText());
//        WebElement dt =
//                browser.findElementByCssSelector("dd.bookDescription");
//        assertEquals("DESCRIPTION", dt.getText());
//    }

//    @AfterClass
//    public static void closeBrowser() {
//        browser.quit();
//    }

}
