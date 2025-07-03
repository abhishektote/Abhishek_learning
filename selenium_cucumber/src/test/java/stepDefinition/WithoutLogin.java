package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonActions;
import pages.HomePage;
import pages.NavigationBar;
import pages.ProductPage;

public class WithoutLogin {

    private HomePage homePage;
    private ProductPage productPage;

    public WithoutLogin(){
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    @Given("the user is on the search page")
    public void checkAmazonHomePage(){
        homePage.returnToHomePage();
    }

    @When("the user types “lap” in the search bar")
    public void searchForLapInTextBox(){
        productPage.searchTextLap();
    }

    @Then("suggestion list must appear")
    public void checkSuggestionListVisibility() {
        productPage.checkVisibilityForSuggestion();
    }

    @And("the list must contain the word “laptop")
    public void validateIfResultContainsLaptop() {
        productPage.validateIfTheResultContainsLaptop();
    }

}
