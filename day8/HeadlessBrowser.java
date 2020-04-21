package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class HeadlessBrowser
{
    WebDriver d = null;

    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();

        ChromeOptions cOps=new ChromeOptions();
        cOps.addArguments("--headless");

        d= new ChromeDriver(cOps);
    }

    @Test
    public void headless_browser()
    {
        d.get("https://www.google.com");
        GoogleHomePage GoogleHomePage_obj1 = new GoogleHomePage(d);
        GoogleHomePage_obj1.setTextGoogleSearchBox("Fernando Torres");
        GoogleHomePage_obj1.clickSubmitButton();
        System.out.println(d.getTitle());
    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
    }
}
