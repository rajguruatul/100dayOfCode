package TestNG;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class TestNG_Priority {

    // If the priority is set to 1 for all methods, what would be sequence of execution ?

    @Test (priority = 1)
    public void One()
    {
        System.out.println("This is test One");
    }
    @Test(priority = 1)
    public void two()
    {
        System.out.println("This is test Two");
    }

    @Test(priority = 1)
    public void three()
    {
        System.out.println("This is test Three");
    }


}
