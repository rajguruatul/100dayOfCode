package TestNG;

import org.testng.annotations.Test;

public class TestNG_RegularExpression {

    @Test(groups = {"windows.testOne"})
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(groups = {"linux.testTwo"})
    public void two()
    {
        System.out.println("This is test Two");
    }
    @Test(groups={"windows.testThree","Linux.testThree"})
    public void three()
    {
        System.out.println("This is test Three");
    }
    @Test(groups = {"mac.testFour"})
    public void four() { System.out.println("This is test four"); }
}
