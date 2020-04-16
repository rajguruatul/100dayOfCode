package listeners;


import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners (listeners.TestNGListener.class)
public class TestNGDemo1 {

    @Test
    public void TestMethod5()
    {
        System.out.println("This is sample PASS method :TestMethod5");
    }

    @Test
    public void TestMethod6()
    {
        System.out.println("This is sample PASS method :TestMethod6");
    }

    @Test
    public void TestMethod7()
    {
        System.out.println("This is sample FAIL method :TestMethod7");
        Assert.assertTrue(false);
    }


    @Test
    public void TestMethod8()
    {
        System.out.println("This is sample SKIPPED method :TestMethod8");
        throw  new SkipException("This Test is skipped");
    }

}
