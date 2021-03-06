Feature: Purchase Foreign Currency

  Scenario: Available currencies
    Given navigate login page
    Given the user is logged in
    When the user clicks on "Pay Bills" module
    Given Navigate "Purchase Foreign Currency" tab
    Then following currencies should be available
              |Australia (dollar)   |
              |Canada (dollar)      |
              |Switzerland (franc)  |
              |China (yuan)         |
              |Denmark (krone)      |
              |Eurozone (euro)      |
              |Great Britain (pound)|
              |Japan (yen)          |
              |Mexico (peso)        |
              |Norway (krone)       |
              |New Zealand (dollar) |
              |Singapore (dollar)   |


  Scenario: Error message for not selecting currency
    Given navigate login page
    Given the user is logged in
    When the user clicks on "Pay Bills" module
    Given Navigate "Purchase Foreign Currency" tab
    Given user enters the Amount
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @wip
  Scenario: Error message for not entering value
    Given navigate login page
    Given the user is logged in
    When the user clicks on "Pay Bills" module
    Given Navigate "Purchase Foreign Currency" tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed