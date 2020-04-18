package TestNG;

import org.testng.annotations.Test;

@Test(groups = {"Regression"})
public class TestNG_ClassGroups {

    @Test(groups = {"smoke"})
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(groups = {"functional"})
    public void two()
    {
        System.out.println("This is test Two");
    }
    @Test(groups={"sanity","performance"})
    public void three()
    {
        System.out.println("This is test Three");
    }
    @Test(groups = {"sanity"})
    public void four() { System.out.println("This is test four"); }
}
