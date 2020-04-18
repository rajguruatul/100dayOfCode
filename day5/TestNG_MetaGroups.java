package TestNG;

import org.testng.annotations.Test;

public class TestNG_MetaGroups {

    @Test(groups = {"smoke"})
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(groups = {"regression"})
    public void two()
    {
        System.out.println("This is test Two");
    }
    @Test(groups={"sanity","regression"})
    public void three()
    {
        System.out.println("This is test Three");
    }
    @Test(groups = {"sanity"})
    public void four() { System.out.println("This is test four"); }
}
