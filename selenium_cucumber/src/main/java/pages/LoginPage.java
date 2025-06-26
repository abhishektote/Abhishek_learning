package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class LoginPage {
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement loginWindow;

    @FindBy(xpath = "//input[@id='ap_email_login']")
    public WebElement nameTextBoxOnLoginWindow;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitForEmailOrMobileText;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBoxOnLoginWindow;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    public WebElement siginButton;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement userNameAfterLogin;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateUserNameAfterLogin(){
        return userNameAfterLogin.getText();
    }
}
