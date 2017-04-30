Feature: User can delete a reference by clicking "Delete" button

  Scenario: user can delete a book reference
    Given a book reference with key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created
    And Edit is pressed for key "MW34"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

  Scenario: user can cancel deleting a book reference
    Given a book reference with key "MW56" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created
    And Edit is pressed for key "MW56"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit a book reference"


  Scenario: user can delete an article reference
    Given an article reference with key "KW10D1" author "Whittington, Keith J." title "Infusing active learning into introductory programming courses" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite"
    And Edit is pressed for key "KW10D1"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

  Scenario: user can cancel deleting an article reference
    Given an article reference with key "KW10D2" author "Whittington, Keith J." title "Infusing active learning into introductory programming courses" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite"
    And Edit is pressed for key "KW10D2"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit an article reference"


    Scenario: user can delete an inproceedings reference
    Given an inproceedings reference with key "MC07D1" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    And Edit is pressed for key "MC07D1"
    When Delete is pressed
    And popup is accepted
    Then system will respond with "Reference deleted successfully!"

    Scenario: user can cancel an inproceedings reference
    Given an inproceedings reference with key "MC07D2" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" year "2017" pubisher "publisher " editor "Elina" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" address "osoite" series "3" startingPage "3" endingPage "6" month "4" organization "organisaatio" are inserted
    And Edit is pressed for key "MC07D2"
    When Delete is pressed
    And popup is not accepted
    Then system will respond with "Edit an article reference"
