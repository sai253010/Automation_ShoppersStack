package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePagePOM
{
    @FindBy(xpath = "//a/descendant::div[text()='My Profile']")
    private WebElement myProfileLink;

    @FindBy(xpath = "//a/descendant::div[text()='My Addresses']")
    private WebElement myAddressLink;

    @FindBy(xpath = "//a/descendant::div[text()='My Wallet']")
    private WebElement myWalletLink;

    @FindBy(xpath = "//a/descendant::div[text()='My Likes']")
    private WebElement myLikesLink;

    public MyProfilePagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getMyProfileLink() {
        return myProfileLink;
    }

    public WebElement getMyAddressLink() {
        return myAddressLink;
    }

    public WebElement getMyWalletLink() {
        return myWalletLink;
    }

    public WebElement getMyLikesLink() {
        return myLikesLink;
    }
}
