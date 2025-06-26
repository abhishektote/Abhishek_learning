package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ErrorMessageConstants;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class AddressPage {
    @FindBy(id = "add-new-address-desktop-sasp-tango-link")
    private WebElement newWindowForAddressDetails;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    private WebElement textBoxForAddressName;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement textBoxForAddressMobileNo;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    private WebElement textBoxForAddressPinCode;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    private WebElement textBoxForAddressLine1;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
    private WebElement textBoxForAddressLine2;

    @FindBy(xpath = "//a[@data-nav-ref='nav_youraccount_btn']")
    private WebElement navigateToYourAccount;

    @FindBy(xpath = "//div[@data-card-identifier='AddressesAnd1Click']")
    private WebElement navigateToYourAddress;

    @FindBy(xpath = "//div[@id='ya-myab-plus-address-icon']")
    private WebElement addAddress;

    @FindBy(xpath = "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
    private WebElement submit;

    @FindBy(xpath = "//div[@id='ya-myab-display-address-block-1']//h5[@id='address-ui-widgets-FullName']")
    private WebElement responseName;

    @FindBy(xpath = "//div[@id='ya-myab-display-address-block-1']//span[@id='address-ui-widgets-AddressLineOne']")
    private WebElement responseHouseNo;

    @FindBy(xpath = "//div[@id='ya-myab-display-address-block-1']//span[@id='address-ui-widgets-AddressLineTwo']")
    private WebElement responseStreetNo;

    @FindBy(xpath = "//div[@id='ya-myab-display-address-block-1']//span[@id='address-ui-widgets-CityStatePostalCode']")
    private WebElement responsePinCode;

    @FindBy(xpath = "//div[@id='ya-myab-display-address-block-1']//span[@id='address-ui-widgets-PhoneNumber']")
    private WebElement responseMobileNo;

    public AddressPage(){
        PageFactory.initElements(driver, this);
    }

    public void getPopupForNewAddressEntry(){
        navigateToYourAccount.click();
        navigateToYourAddress.click();
        addAddress.click();
    }

    public void enterNewAddressDetails(String name, String mobile, String pincode, String houseNo, String streetNo){
        textBoxForAddressName.sendKeys(name);
        textBoxForAddressMobileNo.sendKeys(mobile);
        textBoxForAddressPinCode.sendKeys(pincode);
        textBoxForAddressLine1.sendKeys(houseNo);
        textBoxForAddressLine2.sendKeys(streetNo);
        submit.click();
    }

    public void verifyAddressDetails(String name, String mobile, String pincode, String houseNo, String streetNo){
        Assert.assertEquals(responseName.getText(), name, ErrorMessageConstants.ADDRESS_NAME_FAILED_TO_MATCH);
        String outputMobileNo = responseMobileNo.getText();
        String extractedNumber = outputMobileNo.replaceAll("\\D", "");
        Assert.assertEquals(extractedNumber, mobile, ErrorMessageConstants.ADDRESS_MOBILE_NO_FAILED_TO_MATCH);
        String outputPineCode = responsePinCode.getText();
        String extractedPinCode = outputPineCode.replaceAll("\\D", "");
        Assert.assertEquals(extractedPinCode, pincode, ErrorMessageConstants.ADDRESS_PIN_CODE_FAILED_TO_MATCH);
        Assert.assertEquals(responseHouseNo.getText(), houseNo, ErrorMessageConstants.ADDRESS_HOUSE_NO_FAILED_TO_MATCH);
        Assert.assertEquals(responseStreetNo.getText(), streetNo, ErrorMessageConstants.ADDRESS_STREET_NO_FAILED_TO_MATCH);
    }
}
