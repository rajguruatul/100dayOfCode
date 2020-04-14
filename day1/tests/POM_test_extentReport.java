//I have used the parameter "setDocumentTitle" and "setReportName" for ExtentHtmlReporter objects like below:
//htmlReporter.config().setDocumentTitle("POM test Extent Report Test");
//htmlReporter.config().setReportName("Extent Report Demo ");


package tests;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleHomePage;

public class POM_test_extentReport {

    public static void main(String args[]) {

        String extentRerpotLocation = "C:/Users/USER/IdeaProjects/firstMavenProject/ExtextReports/";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentRerpotLocation +"htmlReport3.html");
            htmlReporter.config().setDocumentTitle("POM test Extent Report Test");
            htmlReporter.config().setReportName("Extent Report Demo ");

            ExtentReports eReport = new ExtentReports();
            eReport.attachReporter(htmlReporter);


            ExtentTest eTest = eReport.createTest("POM_test_exntentReport", "this is the description for the test");

            WebDriverManager.chromedriver().setup();
            WebDriver d = new ChromeDriver();

            try {

            eTest.log(Status.INFO, "Test has started");
            d.get("https://www.google.com");
            d.manage().window().maximize();
            eTest.pass("navigated to google.com");


            GoogleHomePage obj1 = new GoogleHomePage(d);
            obj1.setTextGoogleSearchBox("Luis Suarez");
            eTest.pass("Successfully entered the string to be searched");


            obj1.clickSubmitButton();
            eTest.pass("clicked the search button successfully");


            d.close();
            eTest.pass("Browser is closed");

            eTest.info("Test completed");


        }
        catch(Exception e)
        {
            System.out.println("exception"+e);
            eTest.fail("The test failed with exception"+e);
        }

        eReport.flush();
    }
}
