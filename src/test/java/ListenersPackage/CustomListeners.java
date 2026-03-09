package ListenersPackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
        try
        {
            Object object = result.getInstance();

            Field field = object.getClass().getDeclaredField("driver");

            field.setAccessible(true);

            WebDriver Listenerdriver = (WebDriver) field.get(object);

            TakesScreenshot screenshot = (TakesScreenshot) Listenerdriver;

            File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

            File srcFile = new File("./ScreenShotFolder"+result.getMethod().getMethodName()+"_SS.png");

            FileUtils.copyFile(tempFile,srcFile);

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
