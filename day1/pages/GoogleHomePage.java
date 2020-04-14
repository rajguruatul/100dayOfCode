package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage
{

    WebDriver d=null;
    By googleSearchBox = By.xpath("//input[@title=\"Search\"]");
    By googleSubmitButton = By.name("btnK");


    //constructor
    public GoogleHomePage(WebDriver d)
    {this.d=d;}

    // str is string to set on the google text box
    public void setTextGoogleSearchBox(String str)
    {
        d.findElement(googleSearchBox).clear();
        d.findElement(googleSearchBox).sendKeys(str);

    }

    public void clickSubmitButton()
    {
        d.findElement(googleSubmitButton).sendKeys(Keys.RETURN);
    }

}
