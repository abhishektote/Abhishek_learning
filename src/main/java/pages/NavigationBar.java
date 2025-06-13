package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

public class NavigationBar {
    @FindBy(xpath = ProjectConstants.MOBILE_ON_NAVIGATION_BAR)
    private WebElement mobileOnNavigationBar;
    @FindBy(xpath = ProjectConstants.BOOK_ON_NAVIGATION_BAR)
    private WebElement bookOnNavigationBar;
    @FindBy(xpath = ProjectConstants.ORDER_ON_NAVIGATION_BAR)
    private WebElement orderOnNavigationBar;

    public WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToMobileThroughNavigationBar(){
        mobileOnNavigationBar.click();
    }

    public void navigateToBooksThroughNavigationBar(){
        bookOnNavigationBar.click();
    }

    public void navigateToOrdersThroughNavigationBAr(){
        orderOnNavigationBar.click();
    }
}
