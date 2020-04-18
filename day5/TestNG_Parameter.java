package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class TestNG_Parameter {
    WebDriver d=null;

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName)
    {
        System.out.println("BrowserName is "+browserName);
        System.out.println("Thread ID : "+Thread.currentThread().getId());

        if(browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            d= new ChromeDriver();

        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            d=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            d = new InternetExplorerDriver();
        }
    }

    @Test
    public void OpenBrowser() throws InterruptedException {
        d.get("https://www.google.com");
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown()
    {
        d.close();
    }
}
