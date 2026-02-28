package executionUsing_POM_Utility;


import org.openqa.selenium.WebDriver;
import POM.CartPagePOM;
import POM.HomePagePOM;
import POM.LogInPagePOM;
import POM.ProductPagePOM;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.JSUtility;
import utilityPackage.PropertyFileUtility;

public class PurchasingOneItem
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

    public static void main(String[] args) throws Exception
    {
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

        Thread.sleep(5000);
//        actionUtil.clickOnElement(home.getLoginButton());


        jsUtil.clickOnElementUsingJS(home.getLogInButton());

        actionUtil.writeInsideElement(login.getEmailField(), email);
        actionUtil.writeInsideElement(login.getPasswordField(), password);
        actionUtil.clickOnElement(login.getLogInButton());

        Thread.sleep(4000);

//        jsUtil.scrollFullPage();


        actionUtil.scrollTillElement(home.getDesiredProd());

        home.selectDesiredProduct("FIREBOLT");

        Thread.sleep(2000);

//        actionUtil.clickOnElement(product.getaddToCartBtn());

        jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
        jsUtil.clickOnElementUsingJS(product.getCartIcon());

    }
}
