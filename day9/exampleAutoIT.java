package AutoIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class exampleAutoIT {

    WebDriver d=null;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        d= new ChromeDriver();
    }

    @Test
    public void autoIT_method() throws IOException, InterruptedException {
        d.get("http://www.tinyupload.com/");

        d.findElement(By.xpath("//textarea[@name='file_description']")).sendKeys("This is working");
       WebElement chooseFileButton = d.findElement(By.xpath("//input[@name='uploaded_file']"));

        //used JavaScrip Executor  as <input> tag was not taking click method as legal action
        JavascriptExecutor js = (JavascriptExecutor) d;
        js.executeScript("arguments[0].click();", chooseFileButton);

        //calling the AutoIT Script
        Runtime.getRuntime().exec("C:\\Users\\USER\\git\\100daysOfCode\\100dayOfCode\\day9\\UploadDialog_AutoIT.exe");

        Thread.sleep(10000);



    }

    @AfterTest
    public void teardown()
    {
        d.manage().deleteAllCookies();
        d.close();
    }

}
