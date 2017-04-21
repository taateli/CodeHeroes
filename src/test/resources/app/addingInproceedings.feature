Feature: User can add an inproceedings reference to database by filling mandatory fields

 Scenario: user can add an inproceedings reference with mandatory fields filled
    Given form inproceedings is selected
    When key "MC07" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    Then system will respond with "Reference added successfully!"

  Scenario: user can not add an inproceedings reference with mandatory fields missing
    Given form inproceedings is selected
    When key "MC07" author "" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    Then system will respond with "Field can not be empty!"
