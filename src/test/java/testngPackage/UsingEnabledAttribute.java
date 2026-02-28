package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingEnabledAttribute
{
    @Test
    public void m1()
    {
        Reporter.log("This is m1 Method" , true);
    }

    @Test
    public void m2()
    {
        Reporter.log("This is m2 Method" , true);
    }

    @Test
    public void m3()
    {
        Reporter.log("This is m3 Method" , true);
    }

    @Test
    public void m4()
    {
        Reporter.log("This is m4 Method" , true);
    }
}
