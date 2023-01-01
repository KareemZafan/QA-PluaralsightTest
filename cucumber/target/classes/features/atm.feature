Feature: Cash withdrawal
  Scenario: Successful withdrawal from account
    Given I have $200 in my account
    When I request $20
    Then $20 should be dispensed




