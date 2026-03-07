package ListenersPackage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.lang.reflect.Field;

public class CustomListeners implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log(result.getMethod().getMethodName()+"~~~ this method is started",true);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+"--- this method is successful",true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver;
        try
        {
            Object object = result.getInstance();

            Field field = object.getClass().getDeclaredField("driver");

            field.setAccessible(true);
            driver = (WebDriver)field.get(object);

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

            File srcFile = new File("./Screenshots/"+result.getMethod().getMethodName()+".png");

            FileHandler.copy(tempFile,srcFile);

        }
        catch (Exception e) {
            e.printStackTrace();
        }    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+"--- this method is skipped",true);
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.log(context.getName() +"--- this suite is started",true);
    }

    @Override
    public void onFinish(ITestContext context)
    {
        Reporter.log(context.getName() +"--- this suite is finished",true);
    }
}
