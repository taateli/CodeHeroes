Feature: User can add a book reference to reference database by filling mandatory fields
 
        Scenario: user can add a book reference with mandatory fields filled
        Given form book is selected
        When key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" are inserted
        Then system will respond with "Reference added successfully!"

        Scenario: user cannot add a book reference without mandatory fields filled
        Given form book is selected
        When key "MW34" author "Mika Waltari" title "" year "1934" publisher "Otava" are inserted
        Then system will respond with "Field can not be empty!"
