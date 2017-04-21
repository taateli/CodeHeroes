Feature: User can delete a reference by clicking "Delete" button

     Scenario: user can delete a book reference
        Given a book reference with key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created
        When Delete is pressed
    #   And popup is accepted 
        Then system will respond with "Reference deleted successfully!"