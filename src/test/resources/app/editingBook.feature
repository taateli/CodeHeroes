Feature: User can edit a book reference by clicking "Edit" button

  Scenario: old connection is shut down and new established
    When connection is shut down
    Then new connection is established

  Scenario: user can edit a book reference
    Given a book reference with key "MW74" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created successfully
    When Edit is pressed for key "MW74"
    And system will respond with "Edit a book reference"
    And a book reference with key "MW74" author "Mika Waltari2" title "Sinuhe" year "1934" publisher "Otava" is updated
    Then system will respond with "Reference updated successfully!"
