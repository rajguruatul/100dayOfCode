package Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class Thread_sleep
{

     WebDriver d=null;

    @BeforeTest
    public void setup()
    {
            WebDriverManager.chromedriver().setup();
            d= new ChromeDriver();
    }

    @Test
    public void OpenBrowser() throws InterruptedException {
        d.get("https://www.google.com");


        Thread.sleep(5000);
        GoogleHomePage GoogleHomePage_obj1 = new GoogleHomePage(d);
        GoogleHomePage_obj1.setTextGoogleSearchBox("El Nino");


        Thread.sleep(5000);
        GoogleHomePage_obj1.clickSubmitButton();
    }

    @AfterTest
    public void teardown()
    {
        d.close();
    }


}
