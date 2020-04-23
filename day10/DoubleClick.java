package Actions;

/*Find below the steps of the scenario to be automated:

        1. Launch the web browser and launch our practice page https://demoqa.com/tooltip-and-double-click/
        2. Find the required element i.e. button in our sample and do double click on the element
        3. Accept the alert message
        4. Close the browser to end the program*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick
{


    WebDriver d=null;
    String URL ="http://demoqa.com/tooltip-and-double-click/";

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.silentOutput","true");
        ChromeOptions cops = new ChromeOptions();
        cops.addArguments("start-maximized").addArguments("incognito");

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver(cops);

    }

    @Test
    public void doubleClick() throws InterruptedException {
        d.get(URL);


        WebElement doubleClick_button = d.findElement(By.xpath("//button[@id='doubleClickBtn']"));

        Actions actions = new Actions(d);
        actions.doubleClick(doubleClick_button).click().perform();

        d.switchTo().alert().accept();
        System.out.println("double click successful with accept in alert box");

    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }


}
