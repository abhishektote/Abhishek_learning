package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class PaymentPage {
    @FindBy(xpath = ProjectConstants.RADIO_BUTTON_FOR_ADD_NEW_UPI)
    private WebElement radioButtonForAddNewUPI;

    @FindBy(xpath = ProjectConstants.INPUT_BOX_FOR_UPI_NO)
    private WebElement inputBoxForUPINo;

    @FindBy(xpath = ProjectConstants.VERIFY_UPI)
    private WebElement verifyUpi;

    @FindBy(xpath = ProjectConstants.VALIDATE_UPI)
    private WebElement newPaymentOptionVerification;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void addNewPaymentMethodWithNewCardDetails(){
        radioButtonForAddNewUPI.click();
        inputBoxForUPINo.sendKeys(ProjectConstants.UPI_ID);
        verifyUpi.click();

    }

    public boolean verifyNewPaymentOption(){
        if(newPaymentOptionVerification.isEnabled()){
            return true;
        }
        return false;
    }
}
