package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import java.util.NoSuchElementException;

import static base.WebDriverFactory.driver;

public class ProductPage {
    @FindBy(css = ".nav-a[href*='deals?'")
    private WebElement todaysDeal;

    @FindBy(xpath = "//div[@class='GridItem-module__container_PW2gdkwTj1GQzdwJjejN'][@data-test-index='2']")
    private WebElement thirdDealFromToadysDeal;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@data-index='27']")
    private WebElement lastElementFromSearchResult;

    @FindBy(xpath = "//div[@role='listitem']")
    private WebElement listOfAllMobileSearch;

    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement productTitle;

    public ProductPage() {
        PageFactory.initElements(driver, this);
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

    public String getSelectedProductName(){
        return productTitle.getText();
    }
}
