package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

public class HomePage {

    public WebDriver driver;

    @FindBy(xpath = ProjectConstants.AMAZON_HOME)
    private WebElement homePage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void returnToHomePage(){
        homePage.click();
    }

}
