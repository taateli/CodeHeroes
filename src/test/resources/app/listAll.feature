Feature: User can list all references 

  Scenario: user can list all references by pressing ListAll -button
    Given Front page is opened
    And number of displayed references is calculated
    When ListAll button is pressed
    And number of displayed references is calculated again
    Then the number is same
