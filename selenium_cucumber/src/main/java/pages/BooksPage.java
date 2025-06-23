package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class BooksPage {
    @FindBy(xpath = ProjectConstants.PRIME_CHECKBOX_ON_BOOK_PAGE)
    private WebElement primeCheckBoxOnBookPage;

    @FindBy(xpath = ProjectConstants.PRIME_DELIVERY_STATUS)
    private WebElement primeDeliveryStatus;

    public BooksPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPrimeCheckBox(){
        primeCheckBoxOnBookPage.click();
    }

    public String getDeliveryDateDeatilsForFirstDisplayedItem(){
        return primeDeliveryStatus.getText();
    }
}
