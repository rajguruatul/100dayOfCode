package TestNG;

import org.testng.annotations.Test;

public class TestNG_differentPriority {

    // what would be sequence of execution ?

    @Test(priority = 1)
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(priority = 0)
    public void two()
    {
        System.out.println("This is test Two");
    }

    @Test(priority = -1)
    public void three()
    {
        System.out.println("This is test Three");
    }

}
