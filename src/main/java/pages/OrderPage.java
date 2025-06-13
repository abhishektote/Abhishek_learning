package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

public class OrderPage {
    @FindBy(xpath = ProjectConstants.DATE_DROP_DOWN_ORDER_PAGE)
    private WebElement dateDropDownOrderPage;

    @FindBy(xpath = ProjectConstants.VALUE_FOR_YEAR_SELECTION)
    private WebElement valueForYearSelection;

    @FindBy(xpath = ProjectConstants.SELECT_FIRST_ORDER_FROM_LIST)
    private WebElement selectFirstOrderFromList;


    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectPastYearThroughDropDown(){
        dateDropDownOrderPage.click();
        valueForYearSelection.click();
    }

    public void selectFirstOrderFromList(){
        selectFirstOrderFromList.click();
    }

}
