Feature: Find Transactions in Account Activity


  Scenario: Search date range
    Given navigate login page
    Given the user is logged in
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"


  Scenario: Search description
    Given navigate login page
    Given the user is logged in
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"

  # This scenario has the bug. The zero bank description search is case sensitive. When "online" is used, get nothing
  Scenario: Search description case insensitive
    Given navigate login page
    Given the user is logged in
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"


  Scenario: Type
    Given navigate login page
    Given the user is logged in
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under "Deposit"
    Then results table should show at least one result under "Withdrawal"
    When user selects type "Deposit"
    And clicks search
    Then results table should show at least one result under "Deposit"
    But results table should show no result under "Withdrawal"
    When user selects type "Withdrawal"
    And clicks search
    Then results table should show at least one result under "Withdrawal"
    But results table should show no result under "Deposit"