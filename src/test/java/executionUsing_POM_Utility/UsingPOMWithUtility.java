package executionUsing_POM_Utility;

import POM.CartPagePOM;
import POM.HomePagePOM;
import POM.LogInPagePOM;
import POM.ProductPagePOM;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.PropertyFileUtility;

public class UsingPOMWithUtility
{
    public static String browser;
    public static String email;
    public static String password;
    public static String url;

    PropertyFileUtility property;
    BrowserUtility browserUtil;
    ActionsUtility action;

    HomePagePOM home;
    LogInPagePOM login;
    CartPagePOM cart;
    ProductPagePOM page;


    public static void main(String[] args) {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
