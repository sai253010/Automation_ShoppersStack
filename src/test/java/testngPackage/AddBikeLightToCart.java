package testngPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddBikeLightToCart
{

        WebDriver driver;
        @Test
        public void openBrowser()
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(500,700));
            driver.manage().window().setPosition(new Point(400, 600));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.saucedemo.com");
        }

        @Test(dependsOnMethods = "openBrowser")
        public void doLogin()
        {
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("//input[@id='login-button']")).click();
        }

        @Test(dependsOnMethods = "doLogin")
        public void addBikeLightToCart()
        {
            driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        }

        @Test(dependsOnMethods = "addBikeLightToCart")
        public void purchaseItemFromCart()
        {
            driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

            driver.findElement(By.xpath("//button[@id='checkout']")).click();

            driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("sai");

            driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("asd");

            driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("123456");

            driver.findElement(By.xpath("//input[@id='continue']")).click();

            driver.findElement(By.xpath("//button[@id='finish']")).click();
        }
}
