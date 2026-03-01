package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAddressPagePOM
{
    @FindBy(xpath = "//div[@id='Address Type']/descendant::input")
    private WebElement addressType;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='House/Office Info']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='Street Info']")
    private WebElement streetInfoField;

    @FindBy(xpath = "//input[@id='Landmark']")
    private WebElement landMarkField;

    @FindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiCard-root signup_formCardContainer__-14Xu MuiPaper-elevation0 MuiPaper-rounded')]/descendant::select")
    private WebElement locationsDropDown;

    @FindBy(xpath = "//input[@id='Pincode']")
    private WebElement pinCodefield;

    @FindBy(xpath = "//input[@id='Phone Number']")
    private WebElement phoneNumberField;

    public AddAddressPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddressType() {
        return addressType;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getAddressField() {
        return addressField;
    }

    public WebElement getStreetInfoField() {
        return streetInfoField;
    }

    public WebElement getLandMarkField() {
        return landMarkField;
    }

    public WebElement getLocationsDropDown() {
        return locationsDropDown;
    }

    public WebElement getPinCodefield() {
        return pinCodefield;
    }

    public WebElement getPhoneNumberField() {
        return phoneNumberField;
    }
}
