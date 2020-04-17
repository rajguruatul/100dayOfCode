package TestNG;

import org.testng.annotations.Test;

public class TestNG_Pririty_NoPriority {

    // what would be sequence of execution ?

    @Test
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(priority = 1)
    public void two()
    {
        System.out.println("This is test Two");
    }
    @Test
    public void three()
    {
        System.out.println("This is test Three");
    }
    @Test(priority = -1)
    public void four() { System.out.println("This is test four"); }
}
