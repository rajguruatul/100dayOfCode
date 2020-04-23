package Actions;

/*Practice Exercise to retrieve ToolTip in Selenium with Actions Class.
        Find below the steps of the scenario to be automated:

        1. Open URL http://demoqa.com/tooltip-and-double-click/
        2. Identify ‘div’ web element
        3. Generate action moveToElement and perform the action
        4. Identify webelement displaying tooltip
        5. Retrieve text attribute value
        6. Verify tooltip text value matches with expected text
        7. Close the page*/


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tooltip {


    WebDriver d=null;
    String URL ="http://demoqa.com/tooltip-and-double-click/";
    String txtFromDB = "We ask for your age only for statistical purposes.";

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
    public void verifyToolTip() throws InterruptedException {
        d.get(URL);

        WebElement ageInput = d.findElement(By.xpath("//div[@id='tooltipDemo']"));

        Actions actions =new Actions(d);
        actions.moveToElement(ageInput).perform();

        String txtFromUi= d.findElement(By.xpath("//span[@class='tooltiptext']")).getText();

        Assert.assertEquals(txtFromDB,txtFromUi);



    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }



}
