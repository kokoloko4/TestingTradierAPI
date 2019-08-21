Feature: Market data
  As user I want market information
  In order to perform market actions

  Background:
    Given I have an access token

  Scenario: Get quotes
    When I send a get request with the symbols "AC" to the API
    Then I get the quotes related to the symbols

  Scenario: Post quotes
    When I send a post request with the symbols "AC" to the API
    Then I get the quotes related to the symbols

  Scenario: Get an option chain
    When I send a request to chain module with the symbol "AC" and the expiration date "2019-08-23"
    Then I get the options with the related symbol and expiration date

  Scenario:  Get an option's strike prices
    When I send a request to strikes module with the symbol "AC" and the expiration date "2019-08-23"
    Then I get the strike prices with the related symbol and expiration date

  Scenario: Get an option’s expiration dates
    When I send a request to expirations module with the symbol "AC"
    Then I get the expiration dates related to the symbol

  Scenario: Get historical pricing
    When I send a request to historical module with the symbol "AC"
    Then I get a list with the history related to the company

  Scenario: Get time and sales
    When I send a request to timesales module with the symbol "AC"
    Then I get a list of timesales information

  Scenario: Get clock
    When I send a request to clock module the API
    Then I get the time information about the market

  Scenario: Get the market calendar
    When I send a request with the month "02" of year "2019"
    Then I get the calendar for the given month

  Scenario: Search companies
    When I send a request with the word "alphabet" as query
    Then I get a list with all securities

  Scenario: Search for symbols
    When I send a request with the symbol "goog" as query
    Then I get a list with the securities that contains the symbol
