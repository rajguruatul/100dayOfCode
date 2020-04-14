package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class fisrJavaProgram
{
    public static void main(String[] args) throws InterruptedException {
       WebDriverManager.chromedriver().setup();
        WebDriver d = new ChromeDriver();

        //WebDriverManager.firefoxdriver().setup();
       // WebDriver d = new FirefoxDriver();

        d.get("https://www.google.com");

        d.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("Liverpool");
        d.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys(Keys.RETURN);
        //d.findElement(By.xpath("//img[@alt=\"Google\"]")).click();
        //d.wait(5000);
        //d.findElement(By.xpath("//input[@value=\"Google Search\"][@type=\"submit\"]")).click();



        Assert.assertTrue(d.getTitle().equalsIgnoreCase("liverpool - Google Search"));
        System.out.println("Passed test");
        d.quit();

    }

}
