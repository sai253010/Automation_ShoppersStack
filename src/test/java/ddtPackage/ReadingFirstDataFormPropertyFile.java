package ddtPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

public class ReadingFirstDataFormPropertyFile {

    static WebDriver driver;
    static String browser;
    static String url;
    static String email;
    static String password;

    public static void main(String[] args) {
        try{
            FileInputStream fis=new FileInputStream("./src/test/resources/CommonDataFolder/ShoppersStackProperty.properties");
            Properties property=new Properties();

            property.load(fis);
            browser= property.getProperty("browser");
            url= property.getProperty("url");
            email=property.getProperty("email");
            password= property.getProperty("password");

            switch(browser.toLowerCase())
            {
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver","./src/test/resources/BrowserDrivers/msedgedriver.exe");
                    driver= new EdgeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofDays(25));
            driver.get(url);
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='loginBtn']"))).click();

            driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);

            driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(password);
            driver.findElement(By.xpath("//span[@class='MuiButton-label']")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Account settings']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]/child::li[text()='My Profile']"))).click();

            WebElement accountInfo = driver.findElement(By.xpath("//section[@class='myprofileOutlet']/child::div[@class='myprofileOutlet']/child::table"));

            Thread.sleep(2000);
            String key = wait.until(ExpectedConditions.visibilityOf(accountInfo.findElement(By.xpath("./child::thead/child::tr/child::th[1]")))).getText();
            String value = wait.until(ExpectedConditions.visibilityOf(accountInfo.findElement(By.xpath("./child::tbody/child::tr/child::td[1]")))).getText();

            property.setProperty(key,value);
            FileOutputStream fos = new FileOutputStream("./src/test/resources/ShoppersStackProperty.properties");
            property.store(fos,"Updated by ATE Sandhya");
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}