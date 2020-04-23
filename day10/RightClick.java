package Actions;

/*Find below the steps of the scenario to be automated:

        1. Launch the web browser and launch our practice page https://demoqa.com/tooltip-and-double-click/
        2. Find the required element i.e. button in our sample and do right click on the element
        3. Go to the options ‘copy’ and  click on it
        4. Accept the alert message
        5. Close the browser to end the program*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RightClick {

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
    public void rightClick() throws InterruptedException {
        d.get(URL);

        WebElement ContextClick_button = d.findElement(By.xpath("//button[@id='rightClickBtn']"));

        Actions actions =new Actions(d);
        actions.contextClick(ContextClick_button).perform();

        WebElement copyCommand = d.findElement(By.xpath("//div[contains(text(),'Copy Me')]"));

        // Text -  Weblement.click() and actions.click() - both the methods did not work -so had to use JavascriptExecutor object
        //copyCommand.click();
       //actions.moveToElement(copyCommand).click().perform();

        JavascriptExecutor js = (JavascriptExecutor) d;
        js.executeScript("arguments[0].click();", copyCommand);

        d.switchTo().alert().accept();

    }

        @AfterTest
    public void teardown()
        {
            d.manage().deleteAllCookies();
            d.close();
        }

}
