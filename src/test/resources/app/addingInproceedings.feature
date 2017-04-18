Feature: User can add an inproceedings reference to database by filling mandatory fields

  Scenario: user can add an inproceedings reference with mandatory fields filled
    Given form inproceedings is selected
    When key "MC07" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach"  booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" are inserted
    Then system will respond with "Reference added succesfully!"

  Scenario: user can add an inproceedings reference with mandatory fields filled
    Given form inproceedings is selected
    When key "MC07" author "Caspersen, Michael E. and Bennedsen, Jens" title ""  booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" are inserted
    Then system will respond with "Field can not be empty!"
