Feature: User can list all refererences which include the same tag

  Scenario: user can list all references including the tag (one tag in reference)
    Given book reference with key "key1" author "Mika" title "Sinuhe" year "1934" publisher "Otava" tags "tagi1"is created successfully
    And book reference with key "key2" author "Mika" title "Sinuhe" year "1934" publisher "Otava" tags "tagi2"is created successfully
    And number of displayed references is calculated
    When link tag by name "tagi1" is pressed
    And number of displayed references is calculated again
    Then the number difference is at least "7" less than earlier
    And book reference with data "tagi1" is displayd in the list

  Scenario: user can list all references including the tag (two tags in reference)
    Given book reference with key "key3" author "Mika" title "Sinuhe" year "1934" publisher "Otava" tags "tagi, tagi1"is created successfully
    And book reference with key "key4" author "Mika" title "Sinuhe" year "1934" publisher "Otava" tags "tagi2, tagi3"is created successfully
    And number of displayed references is calculated
    When link tag by name "tagi3" is pressed
    And number of displayed references is calculated again
    Then the number difference is at least "7" less than earlier
    And book reference with data "tagi3" is displayd in the list
