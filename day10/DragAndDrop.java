package Actions;

/*
Find below the steps of the scenario to be automated:

        1. Launch the web browser and launch our practice page https://demoqa.com/droppable/
        2. Find the required source element i.e. ‘Drag me to my target’ object in our sample
        3. Find the required target element i.e. ‘Drop Here’ object in our sample
        4. Now Drag and Drop ‘Drag me to my target’ object to ‘Drop Here’ object
        5. Verify message displayed on ‘Drop Here’ to verify that source element is dropped at the target element
        6. Close the browser to end the program

 */

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

public class DragAndDrop {

    WebDriver d=null;
    String URL ="https://demoqa.com/droppable/";

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
    public void verifyDragAndDrop() throws InterruptedException {
        d.get(URL);

        WebElement src=d.findElement(By.xpath("//div[@id='draggable']"));
        WebElement tgt=d.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions =new Actions(d);
        actions.dragAndDrop(src,tgt).perform();

        if(tgt.getText().contains("Dropped!"))
            System.out.println("passed");
        else
            System.out.println("failed");
    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }


}
