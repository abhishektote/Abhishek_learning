package tests;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import tests.testComponents.BaseTest;
import util.ErrorMessageConstants;

import java.util.NoSuchElementException;

public class WithLogin extends BaseTest {

    private LoginPage loginPage;
    private NavigationBar navigationBar;
    private BooksPage booksPage;
    private OrderPage orderPage;
    private CommonActions commonActions;
    private AddressPage addressPage;
    private PaymentPage paymentPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPage(driver);
        navigationBar = new NavigationBar(driver);
        booksPage = new BooksPage(driver);
        orderPage = new OrderPage(driver);
        commonActions = new CommonActions(driver);
        addressPage = new AddressPage(driver);
        paymentPage = new PaymentPage(driver);
        homePage = new HomePage(driver);

        loginPage.PerformLoginAction();

    }

    @Test(priority = 1)
    public void primeCheckboxAndDeliveryStatusFetch() {
        try {
            navigationBar.navigateToBooksThroughNavigationBar();
            booksPage.clickOnPrimeCheckBox();
            String deliveryDetails = booksPage.getDeliveryDateDeatilsForFirstDisplayedItem();
            System.out.println("Delivery Details: " + deliveryDetails);
            Assert.assertNotNull(deliveryDetails, ErrorMessageConstants.DELIVERY_DETAILS_FAILED);
        } catch (NoSuchElementException | WebDriverException e) {
            throw new RuntimeException(String.format(ErrorMessageConstants.EXCEPTION_MESSAGE, e.getMessage()));
        }
    }

    @Test(priority = 2)
    public void deliveryStatusVerify() {
        try {
            String deliveryStatus = booksPage.getDeliveryDateDeatilsForFirstDisplayedItem();
            System.out.println("Delivery Status: " + deliveryStatus);
            Assert.assertNotNull(deliveryStatus, ErrorMessageConstants.DELIVERY_DETAILS_FAILED);
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.DELIVERY_DETAILS_FAILED + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void navigateAndSelectLastYearOrder() {
        try {
            navigationBar.navigateToOrdersThroughNavigationBAr();
            orderPage.selectPastYearThroughDropDown();
            System.out.println("Successfully selected past year orders.");
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_TO_SELECT_LAST_YEAR + e.getMessage());
        }
    }

    @Test(priority = 4)
    public void addNewPaymentMethodForSelectedProduct() {
        try {
            orderPage.selectFirstOrderFromList();
            commonActions.performBuyNowAction();
            paymentPage.addNewPaymentMethodWithNewCardDetails(driver);
            Assert.assertTrue(paymentPage.verifyNewPaymentOption());
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_TO_ADD_NEW_PAYMENT + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void addNewAddressFroSelectedProduct() {
        try {
            homePage.returnToHomePage();
            addressPage.getPopupForNewAddressEntry();
            addressPage.enterNewAddressDetails();
            addressPage.verifyAddressDetails();
            System.out.println("New address added successfully.");
        } catch (Exception e) {
            throw new RuntimeException(ErrorMessageConstants.FAILED_TO_ADD_NEW_ADDRESS + e.getMessage());
        }
    }

}