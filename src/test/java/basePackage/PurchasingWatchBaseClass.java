package basePackage;

import POM.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import POM.*;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileUtility;

public class PurchasingWatchBaseClass
{

    public WebDriver driver;

    public  String browser;
    public  String email;
    public  String password;
    public  String url;

    public PropertyFileUtility property;
    public BrowserUtility browserUtil;
    public ActionsUtility actionUtil;
    public JSUtility jsUtil;

    public HomePagePOM home;
    public LogInPagePOM login;
    public CartPagePOM cart;
    public ProductPagePOM product;
    public AddressPagePOM address;
    public NavBarPOM nav;

    @BeforeSuite
    public void loadData()
    {
        try
        {
            property = new PropertyFileUtility();
            browserUtil = new BrowserUtility();

            browser = property.getData("browser");
            url = property.getData("url");
            email = property.getData("email");
            password = property.getData("password");

            browserUtil.openBrowser(browser);
            browserUtil.openUrl(url);
            browserUtil.maximizeBrowser();
            browserUtil.waitForElements(15);

            driver = browserUtil.getDriver();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/" , "The Excepted url is not opened");
            Reporter.log("The Excepted Url is opened" , true);


//            driver = browserUtil.getDriver();

            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void loadPage()
    {
        try
        {
            home = new HomePagePOM(driver);
            login = new LogInPagePOM(driver);
            nav = new NavBarPOM(driver);
            cart = new CartPagePOM(driver);
            product = new ProductPagePOM(driver);
            address = new AddressPagePOM(driver);

            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void doLogIn()
    {
        jsUtil.clickOnElementUsingJS(nav.getLogInButton());

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/user-signin" , "The Login Page is not Opened");
        Reporter.log("The Login Page is opened" , true);
        login.performLogIn(email,password);
    }

    @AfterClass
    public void doLogOut()
    {
        actionUtil.clickOnElement(nav.getProfileIcon());
        actionUtil.clickOnElement(nav.getLogoutLink());
    }
}
