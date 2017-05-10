Feature: User can add an inproceedings reference to database by filling mandatory fields

  Scenario: old connection is shut down and new established
    When connection is shut down
    Then new connection is established

  Scenario: user can add an inproceedings reference with mandatory fields filled
    Given form inproceedings is selected
    When key "MC07" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    Then system will respond with "Reference added successfully!"

  Scenario: user can not add an inproceedings reference with mandatory fields missing
    Given form inproceedings is selected
    When key "MC08" author "" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    Then system will respond with "Field can not be empty!"

  Scenario: user can not add an inproceedings reference with ending page smaller than starting page
    Given form inproceedings is selected
    When key "MC09" author "Author" title "Design of McDonalds" year "2017" pubisher "publisher " editor "Elina" booktitle "Research" address "osoite" series "3" startingPage "6" endingPage "1" month "4" organization "organisaatio" are inserted
    Then system will respond with "Ending page cannot be before starting page!"

  Scenario: user can add an inproceedings reference without a key.
    Given form inproceedings is selected
    When key "" author "Caspersen Michael and Bennedsen Jens" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    Then system will respond with "CM2017"
    And system will respond with "Reference added successfully!"
