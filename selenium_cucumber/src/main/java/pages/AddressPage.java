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
    @FindBy(xpath = ProjectConstants.NEW_WINDOW_FOR_ADDRESS_DEATILS)
    private WebElement newWindowForAddressDetails;

    @FindBy(xpath = ProjectConstants.TEXT_BOX_FOR_ADDRESS_NAME)
    private WebElement textBoxForAddressName;

    @FindBy(xpath = ProjectConstants.TEXT_BOX_FOR_ADDRESS_MOBILE_NO)
    private WebElement textBoxForAddressMobileNo;

    @FindBy(xpath = ProjectConstants.TEXT_BOX_FOR_ADDRESS_PIN_CODE)
    private WebElement textBoxForAddressPinCode;

    @FindBy(xpath = ProjectConstants.TEXT_BOX_FOR_ADDRESS_LINE1)
    private WebElement textBoxForAddressLine1;

    @FindBy(xpath = ProjectConstants.TEXT_BOX_FOR_ADDRESS_LINE2)
    private WebElement textBoxForAddressLine2;

    @FindBy(xpath = ProjectConstants.NAVIGATE_TO_YOUR_ACCOUNT)
    private WebElement navigateToYourAccount;

    @FindBy(xpath = ProjectConstants.NAVIGATE_TO_YOUR_ADDRESS)
    private WebElement navigateToYourAddress;

    @FindBy(xpath = ProjectConstants.ADD_ADDRESS)
    private WebElement addAddress;

    @FindBy(xpath = ProjectConstants.SUBMIT)
    private WebElement submit;

    @FindBy(xpath = ProjectConstants.RESPONSE_NAME)
    private WebElement responseName;

    @FindBy(xpath = ProjectConstants.RESPONSE_HOUSE_NO)
    private WebElement responseHouseNo;

    @FindBy(xpath = ProjectConstants.RESPONSE_STREET_NO)
    private WebElement responseStreetNo;

    @FindBy(xpath = ProjectConstants.RESPONSE_PIN_CODE)
    private WebElement responsePinCode;

    @FindBy(xpath = ProjectConstants.RESPONSE_MOBILE_NO)
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
