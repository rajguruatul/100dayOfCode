package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyboardActions {


    WebDriver d=null;
    String URL ="https://demoqa.com/keyboard-events-sample-form/";


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.silentOutput","true");
        ChromeOptions cops = new ChromeOptions();
        cops.addArguments("start-maximized").addArguments("incognito");

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver(cops);

    }

    @Test
    public void verifyKeyboardActions() throws InterruptedException {
        d.get(URL);

        WebElement userName = d.findElement(By.xpath("//input[@id='userName']"));
        WebElement currentAddress = d.findElement(By.xpath("//textarea[@id='currentAddress']"));
        WebElement permanentAddress = d.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        WebElement submitButton = d.findElement(By.xpath("//input[@id='submit']"));

        Actions actions=new Actions(d);

        //Enter value for name field
        actions.sendKeys(userName,"Atul Rajguru").perform();
        Thread.sleep(5000);

        actions.sendKeys(currentAddress,"This is amazing practise site").perform();
        Thread.sleep(5000);

        actions.keyDown(currentAddress,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);

        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);

        actions.keyDown(permanentAddress,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);

        Assert.assertEquals(permanentAddress.getText(),currentAddress.getText());

        actions.click(submitButton).perform();
        Thread.sleep(5000);


        d.switchTo().alert().accept();


    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }



}
