package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import java.util.NoSuchElementException;

public class ProductPage {
    @FindBy(css = ProjectConstants.TODAYS_DEAL)
    private WebElement todaysDeal;
    @FindBy(xpath = ProjectConstants.THIRD_DEAL_FROM_TODAYS_DEAL)
    private WebElement thirdDealFromToadysDeal;
    @FindBy(xpath = ProjectConstants.SEARCH_TEXT_BOX)
    private WebElement searchTextBox;
    @FindBy(xpath = ProjectConstants.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = ProjectConstants.LAST_ELEMENT_FROM_SEARCH_RESULT)
    private WebElement lastElementFromSearchResult;
    @FindBy(xpath = ProjectConstants.LIST_OF_ALL_MOBILE_SEARCH)
    private WebElement listOfAllMobileSearch;

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void goToTodaysDeals() {
        try{
            todaysDeal.click();
        }catch (NoSuchElementException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void selectDealItem() {
        thirdDealFromToadysDeal.click();
    }

    public void searchMobiles() {
        searchTextBox.sendKeys("Mobiles");
        searchButton.click();
    }

    public WebElement scrollAndGetDetailsOfLastItem(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight-3000);");
        return lastElementFromSearchResult;
    }

}
