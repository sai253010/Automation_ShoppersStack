package executionUsing_POM_Utility;

import POM.HomePagePOM;

import POM.LogInPagePOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogInUsingPOM
{
    public static void main(String[] args) {
        try {

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            driver.get("https://www.shoppersstack.com/");

            HomePagePOM home = new HomePagePOM(driver);

            home.getLogInButton().click();

            LogInPagePOM login = new LogInPagePOM(driver);

            login.getEmailField().sendKeys("gvs123@gmail.com");

            login.getPasswordField().sendKeys("Sai@123456");

            login.getLogInButton().click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
