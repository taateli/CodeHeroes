Feature: User can edit an article reference by clicking "Edit" button

  Scenario: user can edit an article reference
    Given an article reference with key "TB06" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" tags "students" is created successfully
    When Edit is pressed for key "TB06"
    And an article reference with key "TB06" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" tags "students" is updated
    Then system will respond with "Reference updated successfully!"
