package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.ErrorMessageConstants;
import util.ProjectConstants;

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

    public WebDriver driver;

    public AddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void getPopupForNewAddressEntry(){
        navigateToYourAccount.click();
        navigateToYourAddress.click();
        addAddress.click();
    }

    public void enterNewAddressDetails(){
        textBoxForAddressName.sendKeys(ProjectConstants.NAME);
        textBoxForAddressMobileNo.sendKeys(ProjectConstants.MOBILE);
        textBoxForAddressPinCode.sendKeys(ProjectConstants.PINCODE);
        textBoxForAddressLine1.sendKeys(ProjectConstants.HOUSE_NO);
        textBoxForAddressLine2.sendKeys(ProjectConstants.STREET_NO);
        submit.click();
    }

    public void verifyAddressDetails(){
        Assert.assertEquals(responseName.getText(), ProjectConstants.NAME, ErrorMessageConstants.ADDRESS_NAME_FAILED_TO_MATCH);
        String outputMobileNo = responseMobileNo.getText();
        String extractedNumber = outputMobileNo.replaceAll("\\D", "");
        Assert.assertEquals(extractedNumber, ProjectConstants.MOBILE, ErrorMessageConstants.ADDRESS_MOBILE_NO_FAILED_TO_MATCH);
        String outputPineCode = responsePinCode.getText();
        String extractedPinCode = outputPineCode.replaceAll("\\D", "");
        Assert.assertEquals(extractedPinCode, ProjectConstants.PINCODE, ErrorMessageConstants.ADDRESS_PIN_CODE_FAILED_TO_MATCH);
        Assert.assertEquals(responseHouseNo.getText(), ProjectConstants.HOUSE_NO, ErrorMessageConstants.ADDRESS_HOUSE_NO_FAILED_TO_MATCH);
        Assert.assertEquals(responseStreetNo.getText(), ProjectConstants.STREET_NO, ErrorMessageConstants.ADDRESS_STREET_NO_FAILED_TO_MATCH);
    }

}
