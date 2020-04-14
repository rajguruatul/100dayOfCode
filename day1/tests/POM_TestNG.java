package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class POM_TestNG {

    WebDriver d = null;

    @BeforeTest
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();

    }

    @Test
    public void GoogleOperation() {
        d.get("https://www.google.com");
        GoogleHomePage GoogleHomePage_obj1 = new GoogleHomePage(d);
        GoogleHomePage_obj1.setTextGoogleSearchBox("Fernando Torres");
        GoogleHomePage_obj1.clickSubmitButton();
    }

    @AfterTest
    public void teardown() {
        d.close();
        System.out.println("test passed");
    }

}
