package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

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

    @FindBy(xpath = ProjectConstants.USERNAME_AFTER_LOGIN)
    public WebElement userNameAfterLogin;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateUserNameAfterLogin(){
        return userNameAfterLogin.getText();
    }
}
