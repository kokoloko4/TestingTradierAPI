Feature: Market data
  As user I want market information
  In order to perform market actions

  Scenario: Get quotes
    Given I want a list of quotes
    When I send a request with the symbols AAPL,AC to the API
    Then I get the quotes related to the symbols

  Scenario: Post quotes
    Given I want a list of quotes
    When I send a  request with the symbols AAPL,AC to the API
    Then I get the quotes related to the symbols

  Scenario: Get an option chain
    Given I want a list of all quotes in an optin chain
    When I send a  request with the symbol AC and the expiration date 2019-08-23
    Then I get the options with the related symbol and expiration date

  Scenario:  Get an option's strike prices
    Given I want a list of strike prices for a specific expiration date
    When I send a request with the symbol AC and the expiration date 2019-08-23
    Then I get the strike prices with the related symbol and expiration date

  Scenario: Get an option’s expiration dates
    Given I want a list of expiration dates for underlaying symbol
    When I send a request with the symbol AC
    Then I get the expiration dates related to the symbol

  Scenario: Get historical pricing
    Given I want a list of historical pricing of a company
    When I send a request with the symbol AC
    Then I get a list with the history related to the company

  Scenario: Get time and sales
    Given I want a list of time and sales of a company
    When I send a request with the symbol AC
    Then I get a list of timesales information

  Scenario: Get the ETB List
    Given I want a list of securities that are be able to be sold
    When I send a request to the API
    Then I get a list of securities available

  Scenario: Get clock
    Given I want to know if the time when the market is open
    When I send a request to the API
    Then I get the time information about the market

  Scenario: Get the market calendar
    Given I want to know the market calendar for a month
    When I send a request with the month 02 of year 2019
    Then I get the calendar for the given month

  Scenario: Search companies
    Given I want to know all companies
    When I send a request with the alphabet query
    Then I get a list with all securities

  Scenario: Search for symbols
    Given I search for symbols using a symbol
    When I send a request with the goog query
    Then I get a list with the securities that contains the symbol

  Scenario: Create a streaming session
    Given I want to create a new streaming session
    When I send a request to the API
    Then I get a url and a sessionId

