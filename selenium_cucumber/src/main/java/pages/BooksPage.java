package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class BooksPage {
    @FindBy(xpath = "//i[@class='a-icon a-icon-prime a-icon-medium apb-browse-refinements-icon']")
    private WebElement primeCheckBoxOnBookPage;

    @FindBy(xpath = "//div[@data-index='2']//div[@data-cy='delivery-recipe']")
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
