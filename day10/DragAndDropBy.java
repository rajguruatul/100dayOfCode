package Actions;

/*
Find below the steps of the scenario to be automated:

    1. Launch the web browser and launch our practice page https://demoqa.com/droppable/
    2. Find the required source element i.e. ‘Drag me to my target’ object in our sample
    3. Calculate required xOffset and yOffset to drag source element in horizontal and vertical direction respectively [For this, calculate xOffset by getting the difference between x location of the source and target element. Similarly, get yOffset by getting the difference between y location of the source and target element]
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

public class DragAndDropBy {

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
    public void verifyDragAndDropBy() throws InterruptedException {
        d.get(URL);

        WebElement src=d.findElement(By.xpath("//div[@id='draggable']"));
        WebElement tgt=d.findElement(By.xpath("//div[@id='droppable']"));

        int src_xOffset = src.getLocation().getX();
        int src_yOffset = src.getLocation().getY();

        int tgt_xOffset = tgt.getLocation().getX();
        int tgt_yOffset = tgt.getLocation().getY();

        int xOffset = (tgt_xOffset-src_xOffset)<=0 ? 10 : tgt_xOffset-src_xOffset;
        int yOffset = (tgt_yOffset - src_yOffset)<=0?10 : tgt_yOffset - src_yOffset;

        System.out.println("xOffset : "+xOffset+ "   yOffset : "+yOffset);

        Actions actions=new Actions(d);
        actions.dragAndDropBy(src,xOffset,yOffset).perform();

        Thread.sleep(5000);

        if(tgt.getText().contains("Dropped!"))
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }

}
