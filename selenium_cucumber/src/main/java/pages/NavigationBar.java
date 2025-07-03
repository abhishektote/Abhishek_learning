package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class NavigationBar {
    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_mobiles']")
    private WebElement mobileOnNavigationBar;

    @FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_books']")
    private WebElement bookOnNavigationBar;

    @FindBy(xpath = "//a[@id='nav-orders']")
    private WebElement orderOnNavigationBar;

    public NavigationBar() {
        PageFactory.initElements(driver, this);
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
