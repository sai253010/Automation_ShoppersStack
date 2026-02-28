package utilityPackage;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsUtility
{
    WebDriver driver;
    Actions action;

    WebDriverWait wait;

    public ActionsUtility(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public  void clickOnElement(WebElement element)
    {
        action.click(wait.until(ExpectedConditions.elementToBeClickable(element))).perform();
    }

    public void writeInsideElement(WebElement element, String data)
    {
        action.sendKeys(wait.until(ExpectedConditions.elementToBeClickable(element)),data);
    }

    public void moveMouseToElement(WebElement element)
    {
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).perform();
    }

    public void scrollTillElement(WebElement element)
    {
//        action.scrollToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).perform();

        for (;;)
        {
            if (element.isDisplayed())
            {
                break;
            }

            try {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
                e.getMessage();
            }

            action.keyDown(Keys.ARROW_DOWN)
                    .keyUp(Keys.ARROW_DOWN)
                    .perform();
        }
    }
}
