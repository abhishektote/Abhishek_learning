package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.CommonActions;
import pages.HomePage;
import pages.NavigationBar;
import pages.ProductPage;
import util.ErrorMessageConstants;
import util.ProjectConstants;

import static base.WebDriverFactory.driver;

public class WithoutLoginSteps {
    private HomePage homePage;
    private ProductPage productPage;
    private NavigationBar navigationBar;
    private CommonActions commonActions;

    public WithoutLoginSteps(){
        homePage = new HomePage();
        productPage = new ProductPage();
        navigationBar = new NavigationBar();
        commonActions = new CommonActions();
    }

    @When("the user clicks on Today's Deal")
    public void the_user_clicks_on_todays_deal() {
        productPage.goToTodaysDeals();
    }

    @When("selects the third deal item")
    public void selects_the_third_deal_item() {
        productPage.selectDealItem();
        Assert.assertNotNull(productPage.getSelectedProductName());
    }

    @When("adds minimum quantity of the product to cart and verifies it")
    public void adds_minimum_quantity_to_cart() {
        commonActions.addToCart();
        commonActions.goToCart();
        String actualQuantity = commonActions.getCartQuantity();
        Assert.assertEquals(actualQuantity, ProjectConstants.MINIMUM_CART_VALUE,
                String.format(ErrorMessageConstants.CART_QUANTITY_NOT_MATCH, actualQuantity));
    }

    @When("the user searches for mobiles in search box")
    public void the_user_searches_for_mobiles() {
        productPage.searchMobiles();
    }

    @Then("the user scrolls to the result list and fetches the last displayed product")
    public void scrolls_and_fetches_last_product() {
        WebElement details = productPage.scrollAndGetDetailsOfLastItem(driver);
        Assert.assertNotNull(details, ErrorMessageConstants.LAST_DISPLAYED_ITEM_NOT_FOUND);
    }

    @Then("the user navigates to Mobile section and returns to the main menu")
    public void navigate_to_mobile_and_back() {
        navigationBar.navigateToMobileThroughNavigationBar();
        homePage.returnToHomePage();
    }
}
