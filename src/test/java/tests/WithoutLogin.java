package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CommonActions;
import pages.HomePage;
import pages.NavigationBar;
import pages.ProductPage;
import tests.testComponents.BaseTest;
import util.ErrorMessageConstants;
import util.ProjectConstants;

public class WithoutLogin extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;
    private NavigationBar navigationBar;
    private CommonActions commonActions;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        navigationBar = new NavigationBar(driver);
        commonActions = new CommonActions(driver);
    }

    @Test(priority = 1)
    public void clickOnTodaysDeal() {
        try {
            productPage.goToTodaysDeals();
            System.out.println("Clicked on Today's Deal successfully.");
        } catch (Exception e) {
            throw new RuntimeException(String.format(ErrorMessageConstants.EXCEPTION_MESSAGE, e.getMessage()));
        }
    }

    @Test(priority = 2)
    public void getThirdDealFromTodaysDeal() {
        try {
            productPage.selectDealItem();
            System.out.println("Third deal item selected successfully.");
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_TO_FETCH_THIRD_ITEM + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void addMinQuantityToCartAndVerify() {
        try {
            commonActions.addToCart();
            commonActions.goToCart();
            String actualQuantity = commonActions.getCartQuantity();
            System.out.println("Cart Quantity: " + actualQuantity);
            Assert.assertEquals(actualQuantity, ProjectConstants.MINIMUM_CART_VALUE,
                    String.format(ErrorMessageConstants.CART_QUANTITY_NOT_MATCH, actualQuantity));
        } catch (Exception e) {
            throw new RuntimeException("Failed to add and verify minimum quantity in cart: " + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void searchMobilesOnSearchBox() {
        try {
            productPage.searchMobiles();
            System.out.println("Mobile search executed successfully.");
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_MOBILE_SEARCH + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void scrollToResultListAndFetchLastDisplayedProduct() {
        try {
            WebElement details = productPage.scrollAndGetDetailsOfLastItem(driver);
            Assert.assertNotNull(details, ErrorMessageConstants.LAST_DISPLAYED_ITEM_NOT_FOUND);
            System.out.println("Last product details: " + details.getText());
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_TO_FETCH_DETAILS_OF_LAST_ITEM + e.getMessage());
        }
    }

    @Test(priority = 6)
    public void navigateToMobileFromNavigationBarAndBackToMainMenu() {
        try {
            navigationBar.navigateToMobileThroughNavigationBar();
            homePage.returnToHomePage();
            System.out.println("Navigated to Mobile and returned to Home Page.");
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.NAVIGATION_FAILED + e.getMessage());
        }
    }

}