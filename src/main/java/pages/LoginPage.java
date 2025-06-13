package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

public class LoginPage {

    @FindBy(xpath = ProjectConstants.LOGIN_WINDOW)
    public WebElement loginWindow;

    @FindBy(xpath = ProjectConstants.NAME_TEXT_BOX_ON_LOGIN_WINDOW)
    public WebElement nameTextBoxOnLoginWindow;

    @FindBy(xpath = ProjectConstants.SUBMIT_FOR_EMAIL_OR_MOBILE_TEXT)
    public WebElement submitForEmailOrMobileText;

    @FindBy(xpath = ProjectConstants.PASSWORD_TEXT_BOX_ON_LOGIN_WINDOW)
    public WebElement passwordTextBoxOnLoginWindow;

    @FindBy(xpath = ProjectConstants.SIGNIN_BUTTON)
    public WebElement siginButton;

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void PerformLoginAction(){
        loginWindow.click();
        nameTextBoxOnLoginWindow.sendKeys(ProjectConstants.USERNAME);
        submitForEmailOrMobileText.click();
        passwordTextBoxOnLoginWindow.sendKeys(ProjectConstants.PASSWORD);
        siginButton.click();
    }
}
