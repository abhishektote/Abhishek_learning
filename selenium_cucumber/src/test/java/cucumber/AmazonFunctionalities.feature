Feature: Comprehensive Validation of Amazon Web Functionalities

  This feature validates multiple user workflows on the Amazon website, including:
  - Navigating through different sections such as Mobiles and Today’s Deals
  - Adding products to the cart and verifying cart quantity
  - Performing product search operations
  - Logging in with valid credentials
  - Adding and verifying new shipping addresses and payment methods
  - Fetching product-specific details and ensuring consistent user interactions

  Scenario: User add a minium quantity of product to cart from today's deal to verify
    When the user clicks on Today's Deal
    And selects the third deal item
    And adds minimum quantity of the product to cart and verifies it

  Scenario: User search for Mobile and get the last displayed product
    When the user searches for mobiles in search box
    Then the user scrolls to the result list and fetches the last displayed product
    And the user navigates to Mobile section and returns to the main menu

  Scenario Outline: User check for prime delivery, fetch past year order and add new payment and address actions with login
    When the user logs in using "<UserName>" and "<password>"
    And navigates to the books section and filters by Prime
    Then the delivery status should be visible and verified
    When the user navigates to past year orders
    And selects the first order from the list
    And adds a new payment method using UPI ID "<upiId>"
    Then the new payment method should be verified
    When the user returns to home page
    And navigates to address section and adds a new address "<name>", "<mobile>", "<pincode>", "<houseNo>", and "<streetNo>"
    Then the address should be verified with "<name>", "<mobile>", "<pincode>", "<houseNo>", and "<streetNo>"

    Examples:
      | UserName              | password | upiId          | name          | mobile     | pincode | houseNo | streetNo                        |
      | examples012@gmail.com | Pass123@ | 9754548456@apl | abhishek tote | 9754548456 | 411027  | A2/23   | Ganesh nagar, Pimple New Sangvi |


