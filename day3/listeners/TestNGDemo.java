package listeners;


import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners (listeners.TestNGListener.class)
public class TestNGDemo  {

    @Test
    public void TestMethod1()
    {

        System.out.println("This is sample PASS method :TestMethod1");
    }

    @Test
    public void TestMethod2()
    {

        System.out.println("This is sample PASS method :TestMethod2");
    }

    @Test
    public void TestMethod3()
    {
        System.out.println("This is sample FAIL method :TestMethod3");
        Assert.assertTrue(false);
    }


    @Test
    public void TestMethod4()
    {
        System.out.println("This is sample SKIPPED method :TestMethod4");
        throw  new SkipException("This Test is skipped");
    }

}
