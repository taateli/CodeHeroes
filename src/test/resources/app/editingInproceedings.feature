Feature: User can edit an inproceedings reference by clicking "Edit" button

  Scenario: old connection is shut down and new established
    When connection is shut down
    Then new connection is established

  Scenario: user can edit an inproceedings reference
    Given an inproceedings reference with key "CB07E" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" tags "programming" is created successfully
    When Edit is pressed for key "CB07E"
    And an inproceedings reference with key "CB07E" author "Caspersen, Michael E. and Bennedsen, Jens" title "Instructional design of a programming course: a learning theoretic approach" booktitle "ICER '07: Proceedings of the third international workshop on Computing education research" year "2007" tags "programming" is updated
    Then system will respond with "Reference updated successfully!"
