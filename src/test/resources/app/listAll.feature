Feature: User can list all references

  Scenario: old connection is shut down and new established
    When connection is shut down
    Then new connection is established

  Scenario: user can list all references by pressing ListAll -button
    Given Front page is opened
    And number of displayed references is calculated
    When ListAll button is pressed
    And number of displayed references is calculated again
    Then the number is same
