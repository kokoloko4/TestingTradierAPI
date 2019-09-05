Feature: Market data
  As user I want market information
  In order to perform market actions

  Scenario: Post quotes
    Given I have a quotes with symbols "AC,AAPL"
    When I send a post request with the symbol "AC,AAPL" to the API
    Then I get the quotes related to the symbols

  Scenario: Get quotes
    Given I have a quotes with symbols "AC"
    When I send a get request with the symbol "AC" to the API
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
    Given I have a list of expirations of symbol
      |VXX|
      |2019-09-06|
      |2019-09-13|
      |2019-09-20|
      |2019-09-27|
      |2019-10-04|
      |2019-10-11|
      |2019-10-18|
      |2019-10-25|
      |2019-11-15|
      |2019-12-20|
      |2020-01-17|
      |2020-02-21|
      |2020-03-20|
      |2020-04-17|
      |2020-05-15|
      |2021-01-15|
    When I send a request to expirations module with the symbol "VXX"
    Then I get the expiration dates related to the symbol

  Scenario: Get historical pricing
    Given I have a list of dates monthly of symbol
    |AC|
    |2019-01-01|
    |2019-02-01|
    |2019-03-01|
    |2019-04-01|
    |2019-05-01|
    |2019-06-01|
    |2019-07-01|
    |2019-08-01|
    |2019-09-01|
    When I send a request to historical module with the symbol "AC" monthly
    Then I get a list with the history related to the company

  Scenario: Verify that the time and sales are from today
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
