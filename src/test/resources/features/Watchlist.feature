Feature: Watchlist
  As a user a want to perform actions over the users Watchlists

  Scenario: Get all watchlists
    Given I have a watchlist saved in the api with the name "My watchlist" and symbols "AAPL,AC"
    When I send a request to the API
    Then I get the users watchlists information

  Scenario: Get a specific watchlist
    Given I have a watchlist saved in the api with the name "My watchlist" and symbols "AAPL,AC"
    When I send a request with the watchlist id "WL01" to the API
    Then I get the information of the specific watchlist

  Scenario: Create a watchlist
    Given I want to create a watchlist with the name "My watchlist" and symbols "AAPL,AC"
    When I send a request with the name "My watchlist" and symbols "AAPL,AC" of the new watchlist
    Then I get the watchlist the watchlist with the name and symbols sent

  Scenario: Update a watchlist
    Given I want to change name of a watchlist to "Updated Watchlist"
    When I send a request with the watchlist id "WL01" and the updated name "Updated Watchlist"
    Then I get the watchlist with the updated information

  Scenario: Delete a specific watchlist
    Given I want to delete the watchlist with the name "Updated Watchlist"
    When I send a request with watchlist id "WL01" to the API
    Then I get the deleted watchlist with related information

  Scenario: Add symbols to specific watchlist
    Given I want to add the symbol "GOOG" to the watchlist with name "Updated watchlist"
    When I send a request with watchlist id "WL01" and the symbols "GOOG"
    Then I get the watchlist with the added symbols

  Scenario: Remove a symbol to a specific watchlist
    Given I want to remove the "GOOG" from the watchlist with name "Updated watchlist"
    When I send a request with the watchlist id "WL01" and the symbol "GOOG"
    Then I get the watchlist with the deleted symbol