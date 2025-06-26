package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class OrderPage {
    @FindBy(xpath = "//span[@role='button']")
    private WebElement dateDropDownOrderPage;

    @FindBy(xpath = "//a[@id='time-filter_3']")
    private WebElement valueForYearSelection;

    @FindBy(xpath = "(//li[@class='order-card__list']//a[@aria-hidden='false'])[1]")
    private WebElement selectFirstOrderFromList;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
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
