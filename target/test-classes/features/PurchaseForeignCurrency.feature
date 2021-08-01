Feature: Purchase Foreign Currency
  @wip
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