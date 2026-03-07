package testngPackage;

import basePackage.PurchasingWatchBaseClass;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddingItemToCartUsingSoftAssertions extends PurchasingWatchBaseClass
{
    @Test
    public void getElectronics()
    {
        SoftAssert soft = new SoftAssert();


//        soft.assertEquals(home , home);
        soft.assertTrue(nav.getProfileIcon().isDisplayed() , "The Excepted Icon is Not displayed");
        Reporter.log("The Excepted Icon is Displayed", true);
//        soft.assertFalse(condition);

        actionUtil.moveMouseToElement(nav.getShopperStackIcon());

        actionUtil.scrollTillElement(home.getDesiredProd());

        soft.assertTrue(home.getDesiredProd().isDisplayed() , "The desired Product is Not Displayed");
        Reporter.log("The desired Product is Displayed");

        soft.assertTrue(product.getaddToCartBtn().isDisplayed() , "The Add to cart Is Not Displayed");
        Reporter.log("The Add to cart is Displayed");

        actionUtil.clickOnElement(product.getaddToCartBtn());

        soft.assertAll();


    }
}
