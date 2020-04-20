package Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Implicit_wait {


    By Repository_tab=By.xpath("//a[contains(text(),'Repositories')]");
    By Atul_100daysCodeRepo=By.xpath("//div[@id='user-repositories-list']//a[contains(text(),'100dayOfCode')]");
    By commit_tab = By.xpath("//li[@class='commits']//a[1]");


    WebDriver d=null;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }

@Test
public void Implicit_wait_method()
{
    d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    d.get("https://github.com/rajguruatul");
    d.manage().window().maximize();
    d.findElement(Repository_tab).click();
    d.findElement(Atul_100daysCodeRepo).click();

    System.out.println("Before the assertStatement");
    Assert.assertTrue(d.findElement(commit_tab).isDisplayed());
    Assert.assertTrue(d.getTitle().contains("rajguruatul/100dayOfCode"));
    System.out.println("After the assertStatement");


}

@AfterTest
    public void teardown()
{
    d.manage().deleteAllCookies();
    d.close();
}

}

