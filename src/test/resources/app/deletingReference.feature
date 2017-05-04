Feature: User can delete a reference by clicking "Delete" button

  Scenario: user can delete a book reference
    Given a book reference with key "MW34A" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created successfully
    And Edit is pressed for key "MW34A"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

  Scenario: user can cancel deleting a book reference
    Given a book reference with key "MW56" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created successfully
    And Edit is pressed for key "MW56"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit a book reference"

  Scenario: user can delete an article reference
    Given an article reference with key "TB06D1" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" tags "students" is created successfully
    And Edit is pressed for key "TB06D1"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

  Scenario: user can cancel deleting an article reference
    Given an article reference with key "TB06D2" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" tags "students" is created successfully
    And Edit is pressed for key "TB06D2"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit an article reference"

  Scenario: user can delete an inproceedings reference
    Given an inproceedings reference with key "CB07D1" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" tags "programming" is created successfully
    When Edit is pressed for key "CB07D1"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

  Scenario: user can cancel deleting an inproceedings reference
    Given an inproceedings reference with key "CB07D2" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" tags "programming" is created successfully
    When Edit is pressed for key "CB07D2"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit an inproceedings reference"
