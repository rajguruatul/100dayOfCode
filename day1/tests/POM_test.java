package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleHomePage;

public class POM_test
{
public static void main(String args[])
{

 GoogleOperation();
}

public static void GoogleOperation()
{

 WebDriverManager.chromedriver().setup();
 WebDriver d = new ChromeDriver();


 d.get("https://www.google.com");

 GoogleHomePage GoogleHomePage_obj1 = new GoogleHomePage(d);
 GoogleHomePage_obj1.setTextGoogleSearchBox("Fernando Torres");
 GoogleHomePage_obj1.clickSubmitButton();


 d.close();
 System.out.println("test passed");

}
}
