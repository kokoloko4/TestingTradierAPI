Feature: Watchlist
  As a user a want to perform actions over the users Watchlists

  Scenario: Get all watchlists
    Given I want to know all users watchlists
    When I send a request to he API
    Then I get the users watchlists information

  Scenario: Get a specific watchlist
    Given I want a specific watchlist
    When I send a request with the watchlist id to the API
    Then I get the information of the specific watchlist

  Scenario: Create a watchlist
    Given I want to create a watchlist
    When I send a request with the name and symbols of the new watchlist
    Then I get a the watchlist with a public id and important information

  Scenario: Update a watchlist
    Given I want to update a existing watchlist
    When I send a request with the watchlist id and the updated name
    Then I get the watchlist with the updated information

  Scenario: Delete a specific watchlist
    Given I want to delete a existing watchlist
    When I send a request with watchlist id to the API
    Then I get the deleted watchlist with related information

  Scenario: Add symbols to specific watchlist
    Given I want to add symbols to a existing watchlist
    When I send a request with watchlist id and the symbols to add
    Then I get the watchlist with the added symbols

  Scenario: Remove a symbol to a specific watchlist
    Given I want to remove a specific symbol for a watchlist
    When I send a request with the watchlist id and the symbol to remove
    Then I get the watchlist without the deleted symbol