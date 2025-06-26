package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class CommonActions {
    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyNowButton;

    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@href='/cart?ref_=sw_gtc']")
    private WebElement goToCart;

    @FindBy(xpath = "//span[@data-a-selector='value']")
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
