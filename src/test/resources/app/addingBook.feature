Feature: User can add a book reference to reference database by filling mandatory fields

 Scenario: old connection is shut down and new established
     When connection is shut down
    Then new connection is established
 

  Scenario: user can add a book reference with mandatory fields filled
    Given form book is selected
    When key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" are inserted
    Then system will respond with "Reference added successfully!"

  Scenario: user cannot add a book reference without mandatory fields filled
    Given form book is selected
    When key "MW34" author "Mika Waltari" title "" year "1934" publisher "Otava" are inserted
    Then system will respond with "Field can not be empty!"

  Scenario: user can add a book reference without a key
    Given form book is selected
    When key "" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" are inserted
    Then system will respond with "MW1934"
    And system will respond with "Reference added successfully!"
