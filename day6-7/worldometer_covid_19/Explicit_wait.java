package Wait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Explicit_wait {

    WebDriver d = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();

    }

    @Test
    public void explicit_wait_method() {
        String country = "India";
        String URL="https://www.worldometers.info/coronavirus/";
        LinkedHashMap<String, String> covidDetails = new LinkedHashMap();
        String header=null;
        String value=null;

        d.get(URL);
        d.manage().window().maximize();

        //using Explicit wait for loading the Table with all details
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th")));

        int header_size = d.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th")).size();
        for (int i = 1; i <= header_size; i++)
        {
            header=d.findElement(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th[" + i + "]")).getText().replace("\n"," ");
            if (i <= 1)
                value= d.findElement(By.xpath("//table[@id='main_table_countries_today']//a[contains(text(),'" + country + "')]/../../td[" + i + "]/a")).getText();
            else
                value=d.findElement(By.xpath("//table[@id='main_table_countries_today']//a[contains(text(),'"+country+"')]/../../td[" + i + "]")).getText();

           if(value.isEmpty()) value="NOT UPDATED";

           covidDetails.put(header,value);
            System.out.print(header);
            System.out.println(" : "+value);
        }

        //System.out.println(Arrays.asList(covidDetails));


    }

    @AfterTest
    public void teardown() {
        d.manage().deleteAllCookies();
        d.close();
    }

}
