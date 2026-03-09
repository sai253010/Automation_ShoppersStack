package testngPackage;

import ListenersPackage.CustomListeners;
import basePackage.PurchasingWatchBaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


    @Listeners(CustomListeners.class)
    public class PurchasingWatchUsingSoftAssertion extends PurchasingWatchBaseClass {

        WebDriver driver = browserUtil.getDriver();


        public void openHomePage() {
            driver = browserUtil.getDriver();

            SoftAssert soft = new SoftAssert();

            soft.assertEquals(driver.getCurrentUrl(), "https://www.shoppersstack.com/", "The login was unsuccesful");
            Reporter.log("The login was succesfull");

            actionUtil.scrollTillElement(home.getDesiredProd());
            soft.assertTrue(home.getDesiredProd().isDisplayed(),"The DesiredProduct is not displayed");
            Reporter.log("The desired Product is displayed",true);
            actionUtil.clickOnElement(home.getDesiredProd());

            try{
                Thread.sleep(2000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
            soft.assertEquals(product.getaddToCartBtn().getText().toLowerCase(),"added","The Product is not added to Cart");
            Reporter.log("The product is added to Cart",true);

            soft.assertAll();
        }

        @Test
        public void selectDesiredProduct() {
            SoftAssert soft=new SoftAssert();

            actionUtil.scrollTillElement(home.getDesiredProd());
            soft.assertTrue(home.getDesiredProd().isDisplayed(),"The DesiredProduct is not displayed");
            Reporter.log("The desired Product is displayed",true);
            actionUtil.clickOnElement(home.getDesiredProd());


            try{
                Thread.sleep(2000);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            soft.assertAll();
        }

        @Test
        public void AddToCart() {
            SoftAssert soft=new SoftAssert();

            jsUtil.clickOnElementUsingJS(product.getaddToCartBtn());
            soft.assertEquals(product.getaddToCartBtn().getText().toLowerCase(),"added","The Product is not added to Cart");
            Reporter.log("The product is added to Cart",true);

            soft.assertAll();

        }
    }

