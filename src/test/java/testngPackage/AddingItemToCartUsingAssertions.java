package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddingItemToCartUsingAssertions extends PurchasingWatchBaseClass
{
    @Test
    public void getElectronics()
    {
//        actionUtil.clickOnElement(nav.getElectronicsLink());

        Assert.assertTrue(nav.getProfileIcon().isDisplayed() , "The Profile Icon Is Not Displayed");
        Reporter.log("The Profile icon is Displayed" , true);


        actionUtil.moveMouseToElement(nav.getShopperStackIcon());

//        browserUtil.refreshBrowser();

        actionUtil.scrollTillElement(home.getDesiredProd());

        Assert.assertTrue(home.getDesiredProd().isDisplayed() , "The Desired Product is not Displayed");
        Reporter.log("The Desired Product is Displayed", true);

        actionUtil.clickOnElement(home.getDesiredProd());
        Assert.assertTrue(product.getaddToCartBtn().isDisplayed() , "The AddToCart Button is not Displayed");
        Reporter.log("The AddToCart Button is  Displayed" , true);

        actionUtil.moveMouseToElement(product.getaddToCartBtn());


        actionUtil.clickOnElement(product.getaddToCartBtn());


    }

}
