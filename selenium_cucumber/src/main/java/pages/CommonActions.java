package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class CommonActions {
    @FindBy(xpath = ProjectConstants.BUY_NOW_BUTTON)
    private WebElement buyNowButton;

    @FindBy(xpath = ProjectConstants.ADD_TO_CART)
    private WebElement addToCart;

    @FindBy(xpath = ProjectConstants.GO_TO_CART)
    private WebElement goToCart;

    @FindBy(xpath = ProjectConstants.GET_CART_QUANTITY)
    private WebElement getCartQuantity;

    public CommonActions() {
        PageFactory.initElements(driver, this);
    }

    public void performBuyNowAction(){
        buyNowButton.click();
    }

    public void addToCart() {
        addToCart.click();
    }

    public void goToCart() {
        goToCart.click();
    }

    public String getCartQuantity() {
        return getCartQuantity.getText();
    }
}
