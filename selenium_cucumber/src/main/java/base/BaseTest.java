package base;

import pages.*;

public class BaseTest {
    protected LoginPage loginPage;
    protected NavigationBar navigationBar;
    protected BooksPage booksPage;
    protected OrderPage orderPage;
    protected CommonActions commonActions;
    protected AddressPage addressPage;
    protected PaymentPage paymentPage;
    protected HomePage homePage;
    protected ProductPage productPage;

    protected void createLoginPageInstance() {
        loginPage = new LoginPage();
    }

    protected void createNavigationPageInstance() {
        navigationBar = new NavigationBar();
    }

    protected void createBooksPageInstance() {
        booksPage = new BooksPage();
    }

    protected void createOrderPageInstance() {
        orderPage = new OrderPage();
    }

    protected void createCommonActionsPageInstance() {
        commonActions = new CommonActions();
    }

    protected void createAddressPageInstance() {
        addressPage = new AddressPage();
    }

    protected void createPaymentPageInstance() {
        paymentPage = new PaymentPage();
    }

    protected void createHomePageInstance() {
        homePage = new HomePage();
    }

    protected void createProductPageInstance() {
        productPage = new ProductPage();
    }
}
