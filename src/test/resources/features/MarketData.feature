Feature: Market data
  As user I want market information
  In order to perform market actions

  Scenario: Get quotes
    Given I have a quote with symbol "AC"
    When I send a get request with the symbol "AC" to the API
    Then I get the quotes related to the symbols

  Scenario: Post quotes
    Given I have a quote with symbol "AC"
    When I send a post request with the symbol "AC" to the API
    Then I get the quotes related to the symbols

  Scenario: Get an option chain
    Given I have a list of options chains of symbol "VXX" and expiration date "2019-09-20"
    When I send a request to chain module with the symbol "VXX" and the expiration date "2019-09-20"
    Then I get the options with the related symbol and expiration date

  Scenario:  Get an option's strike prices
    Given I have a list of strikes of "VXX" at "2019-09-06"
    When I send a request to strikes module with the symbol "VXX" and the expiration date "2019-09-06"
    Then I get the strike prices with the related symbol and expiration date

  Scenario: Get an option’s expiration dates
    Given I have a list of expirations of "VXX"
    When I send a request to expirations module with the symbol "VXX"
    Then I get the expiration dates related to the symbol

  Scenario: Get historical pricing
    Given I have a list of dates monthly of "AC"
    When I send a request to historical module with the symbol "AC" monthly
    Then I get a list with the history related to the company

  Scenario: Get time and sales
    Given I have a time and sales of "AC"
    When I send a request to timesales module with the symbol "AC"
    Then I get a list of timesales information

  Scenario: Get clock
    Given I have the hour when the market opens
    When I send a request to clock module the API
    Then I get the time information about the market

  Scenario: Get the market calendar
    Given I want the calendar of "2" of "2019"
    When I send a request with the month "02" of year "2019"
    Then I get the calendar for the given month

  Scenario: Search companies
    Given I want the security with the word "alphabet" in its description
    When I send a request with the word "alphabet" as query
    Then I get a list with all securities

  Scenario: Search for symbols
    Given I want the companies that have the symbol "GOOG"
    When I send a request with the symbol "GOOG" as query
    Then I get a list with the securities that contains the symbol
