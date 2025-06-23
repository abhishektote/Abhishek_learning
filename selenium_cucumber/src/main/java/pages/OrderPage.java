package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class OrderPage {
    @FindBy(xpath = ProjectConstants.DATE_DROP_DOWN_ORDER_PAGE)
    private WebElement dateDropDownOrderPage;

    @FindBy(xpath = ProjectConstants.VALUE_FOR_YEAR_SELECTION)
    private WebElement valueForYearSelection;

    @FindBy(xpath = ProjectConstants.SELECT_FIRST_ORDER_FROM_LIST)
    private WebElement selectFirstOrderFromList;

    @FindBy(xpath = ProjectConstants.DROP_DOWN_VALUE_YEAR)
    private WebElement dropDownValueYear;

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectPastYearThroughDropDown(){
        dateDropDownOrderPage.click();
        valueForYearSelection.click();
    }

    public String getValueOfYearSelected(){
        return dropDownValueYear.getText();
    }

    public void selectFirstOrderFromList(){
        selectFirstOrderFromList.click();
    }
}
