package testngPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FirstTestNGExecution
{
    @Test (priority = 1)
    public void login()
    {
        Reporter.log("Login Successfull", true);
    }

    @Test (priority = 2)
    public  void friendRequest()
    {
        Reporter.log("Friend request Sent" , true);
    }

    @Test (priority = -6)
    public void notification()
    {
        Reporter.log("Notification is visible" , true);
    }

}