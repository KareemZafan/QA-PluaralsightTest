Feature: Addition
  Scenario: Adding multiple values
    Given i have  1 , 3 and  4
    When adding 1, 3 ,4
    Then result should be 8


    Scenario: Subtraction
      When subtracting 1, 2, 3
      Then result should be -4

