package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import util.ErrorMessageConstants;
import util.ProjectConstants;

public class WithLoginSteps {
    private LoginPage loginPage;
    private NavigationBar navigationBar;
    private BooksPage booksPage;
    private OrderPage orderPage;
    private CommonActions commonActions;
    private AddressPage addressPage;
    private PaymentPage paymentPage;
    private HomePage homePage;

    public WithLoginSteps(){
        loginPage = new LoginPage();
        navigationBar = new NavigationBar();
        booksPage = new BooksPage();
        orderPage = new OrderPage();
        commonActions = new CommonActions();
        addressPage = new AddressPage();
        paymentPage = new PaymentPage();
        homePage = new HomePage();
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String email, String password) {
        loginPage.loginWindow.click();
        loginPage.nameTextBoxOnLoginWindow.sendKeys(email);
        loginPage.submitForEmailOrMobileText.click();
        loginPage.passwordTextBoxOnLoginWindow.sendKeys(password);
        loginPage.siginButton.click();
        Assert.assertEquals(ProjectConstants.NAME, loginPage.validateUserNameAfterLogin());
    }

    @And("navigates to the books section and filters by Prime")
    public void the_user_navigates_to_books_and_selects_prime_checkbox() {
        navigationBar.navigateToBooksThroughNavigationBar();
        booksPage.clickOnPrimeCheckBox();
    }

    @Then("the delivery status should be visible and verified")
    public void the_delivery_status_for_the_first_displayed_item_should_be_visible() {
        String deliveryDetails = booksPage.getDeliveryDateDeatilsForFirstDisplayedItem();
        Assert.assertNotNull(deliveryDetails, ErrorMessageConstants.DELIVERY_DETAILS_FAILED);
    }

    @When("the user navigates to past year orders")
    public void the_user_navigates_to_past_year_orders() {
        navigationBar.navigateToOrdersThroughNavigationBAr();
        orderPage.selectPastYearThroughDropDown();
        Assert.assertEquals(orderPage.getValueOfYearSelected(), ProjectConstants.PREVIOUS_YEAR);
    }

    @When("selects the first order from the list")
    public void selects_the_first_order_from_list() {
        orderPage.selectFirstOrderFromList();
    }

    @When("adds a new payment method using UPI ID {string}")
    public void adds_new_payment_method(String upiId) {
        commonActions.performBuyNowAction();
        paymentPage.addNewPaymentMethodWithNewCardDetails();
    }

    @Then("the new payment method should be verified")
    public void new_payment_method_should_be_verified() {
        Assert.assertTrue(paymentPage.verifyNewPaymentOption());
    }

    @When("the user returns to home page")
    public void user_returns_to_home_page() {
        homePage.returnToHomePage();
    }

    @When("navigates to address section and adds a new address {string}, {string}, {string}, {string}, and {string}")
    public void navigates_to_address_section_and_adds_a_new_address(String name, String mobile, String pincode, String houseNo, String streetNo) {
        addressPage.getPopupForNewAddressEntry();
        addressPage.enterNewAddressDetails(name, mobile, pincode, houseNo, streetNo);
    }

    @Then("the address should be verified with {string}, {string}, {string}, {string}, and {string}")
    public void verify_address(String name, String mobile, String pincode, String houseNo, String streetNo) {
        addressPage.verifyAddressDetails(name, mobile, pincode, houseNo, streetNo);
    }
}
