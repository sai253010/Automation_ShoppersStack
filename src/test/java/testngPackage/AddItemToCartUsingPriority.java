package testngPackage;

import org.openqa.selenium.WebDriver;
import POM.CartPagePOM;
import POM.HomePagePOM;
import POM.LogInPagePOM;
import POM.ProductPagePOM;
import org.testng.annotations.Test;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileUtility;

public class AddItemToCartUsingPriority
{
    static WebDriver driver;
    public static String browser;
    public static String email;
    public static String password;
    public static String url;

    static PropertyFileUtility property;
    static BrowserUtility browserUtil;
    static ActionsUtility actionUtil;
    static JSUtility jsUtil;


    static HomePagePOM home;
    static LogInPagePOM login;
    static CartPagePOM cart;
    static ProductPagePOM product;

//    @Test (priority = 1)
    @Test
    public void loadData()
    {
        try {
            property = new PropertyFileUtility();

            browser= property.getData("browser");
            url = property.getData("url");
            email = property.getData("email");
            password = property.getData("password");

            browserUtil = new BrowserUtility();

            browserUtil.openBrowser(browser);
            browserUtil.maximizeBrowser();
            browserUtil.openUrl(url);
            browserUtil.waitForElements(30);

            driver = browserUtil.getDriver();


            home = new HomePagePOM(driver);
            login = new LogInPagePOM(driver);
            product = new ProductPagePOM(driver);
            cart = new CartPagePOM(driver);


            actionUtil = new ActionsUtility(driver);
            jsUtil = new JSUtility(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//    @Test (priority = 2)
    @Test(dependsOnMethods = "loadData")
    public void doLogin()
    {
        jsUtil.clickOnElementUsingJS(home.getLogInButton());

        actionUtil.writeInsideElement(login.getEmailField(), email);
        actionUtil.writeInsideElement(login.getPasswordField(), password);
        actionUtil.clickOnElement(login.getLogInButton());
    }

//    @Test(priority = 3)
    @Test(dependsOnMethods = "loadData")
    public void addItemToCart()
    {
        try {

            actionUtil.scrollTillElement(home.getDesiredProd());

            home.selectDesiredProduct("FIREBOLT");

//            actionUtil.clickOnElement(product.getaddToCartBtn());

           Thread.sleep(2000);

           jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
           jsUtil.clickOnElementUsingJS(product.getCartIcon());

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
