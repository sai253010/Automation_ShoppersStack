package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UsingSoftAssertions extends PurchasingWatchBaseClass
{
    @Test
    public void additem()
    {
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/" , "The Login Unsuccessful");
        Reporter.log("The Login is successful" , true);

        actionUtil.scrollTillElement(home.getDesiredProd());

        soft.assertTrue(home.getDesiredProd().isDisplayed() , "The Desired Product is Not Opened");
        Reporter.log("The Desired Product Is Opened" , true);

        actionUtil.clickOnElement(home.getDesiredProd());
        actionUtil.clickOnElement(product.getaddToCartBtn());

        actionUtil.clickOnElement(product.getHomebtn());

        actionUtil.scrollTillElement(home.getDesiredProd());

//        soft.assertTrue(home.getdesiredprod().isDisplayed() , "The desired product is not opened");
//        Reporter.log("The desired product is opened" , true);
//
//        actionUtil.clickOnElement(home.getdesiredprod());
        actionUtil.clickOnElement(product.getaddToCartBtn());

        actionUtil.clickOnElement(cart.getcartIcon());
        soft.assertTrue(cart.getremoveFromCartBtn().isDisplayed() , "The Remove From Cart is Not Displayed");
        Reporter.log("The Remove From Cart is Displayed" , true);
        actionUtil.clickOnElement(cart.getremoveFromCartBtn());

        actionUtil.clickOnElement(cart.getYesbtn());


    }
}
