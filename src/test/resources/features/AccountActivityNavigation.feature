Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given navigate login page
    Then the user is logged in
    When the user clicks on Savings link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have selected "Savings"


  Scenario: Brokerage account redirect
    Given navigate login page
    Given the user is logged in
    When the user clicks on Brokerage link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have selected "Brokerage"


  Scenario: Checking account redirect
    Given navigate login page
    Given the user is logged in
    When the user clicks on Checking link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have selected "Checking"


  Scenario: Credit Card account redirect
    Given navigate login page
    Given the user is logged in
    When the user clicks on Credit Card link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have selected "Credit Card"


  Scenario: Loan account redirect
    Given navigate login page
    Given the user is logged in
    When the user clicks on Loan link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have selected "Loan"
