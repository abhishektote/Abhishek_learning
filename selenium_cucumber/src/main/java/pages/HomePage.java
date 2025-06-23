package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class HomePage {
    @FindBy(xpath = ProjectConstants.AMAZON_HOME)
    private WebElement homePage;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void returnToHomePage(){
        homePage.click();
    }
}
