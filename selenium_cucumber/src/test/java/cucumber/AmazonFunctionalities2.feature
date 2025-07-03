Feature: Search Suggestions

  Scenario: User types partial product name
    Given the user is on the search page
    When the user types “lap” in the search bar
    Then suggestion list must appear
    And the list must contain the word “laptop

