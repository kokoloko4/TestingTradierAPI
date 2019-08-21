Feature: Watchlist
  As a user a want to perform actions over the users Watchlists

  Background:
    Given I have an access token

  Scenario: Get all watchlists
    When I send a request to the API
    Then I get the users watchlists information

  Scenario: Get a specific watchlist
    When I send a request with the watchlist id "WL01" to the API
    Then I get the information of the specific watchlist

  Scenario: Create a watchlist
    When I send a request with the name "My Watchlist" and symbols "AAPL,AC" of the new watchlist
    Then I get a the watchlist with a public id and important information

  Scenario: Update a watchlist
    When I send a request with the watchlist id "WL01" and the updated name "Updated Watchlist"
    Then I get the watchlist with the updated information

  Scenario: Delete a specific watchlist
    When I send a request with watchlist id "WL01" to the API
    Then I get the deleted watchlist with related information

  Scenario: Add symbols to specific watchlist
    When I send a request with watchlist id "WL01" and the symbols "GOOG"
    Then I get the watchlist with the added symbols

  Scenario: Remove a symbol to a specific watchlist
    When I send a request with the watchlist id "WL01" and the symbol "GOOG"
    Then I get the watchlist with the deleted symbol