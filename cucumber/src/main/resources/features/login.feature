
  Feature: Login Functionality
    Scenario: Successful login to the internet website
      Given I navigate to "https://the-internet.herokuapp.com/login"
      When Enter valid username
      And Enter valid password
      Then Should successfully logged In
      And Green ribbon should appear


      Scenario Outline: Unsuccessful Login
        Given I navigate to "https://the-internet.herokuapp.com/login"
        When Enter invalid username "<username>"
        And Enter invalid password "<password>"
        Then Should unsuccessfully logged In
        And Red ribbon should appear
        Examples:
        |username | password |
        |Ahmed    | ali      |
        |Kareem   |123Abc    |
        |         |          |
        |         |Ahmed     |
        |Kareem   |          |

