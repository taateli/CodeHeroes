Feature: User can edit a book reference by clicking "Edit" button

  Scenario: user can edit a book reference
    Given a book reference with key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created
    When Edit is pressed
    And a book reference with key "MW34" author "Mika Waltari2" title "Sinuhe" year "1934" publisher "Otava" is updated
    Then system will respond with "Reference updated successfully!"