package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class PaymentPage {
    @FindBy(xpath = "//div[@aria-label='Other UPI Apps']")
    private WebElement radioButtonForAddNewUPI;

    @FindBy(xpath = "//input[@placeholder='Enter UPI ID']")
    private WebElement inputBoxForUPINo;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")
    private WebElement verifyUpi;

    @FindBy(xpath = "//div[@class='a-box a-alert-inline a-alert-inline-success']")
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
