Feature: User can edit an article reference by clicking "Edit" button

  Scenario: user can edit an article reference
    Given an article reference with key "TB06" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" number "2" startingPage "109" endingPage "114" publisher "Consortium for Computing Sciences"  address "USA" is created
    When Edit is pressed for key "TB06"
    And a book reference with key "TB06" author "Black, Toni R." title "Helping novice programming students succeed" year "2006" journal "J. Comput. Small Coll." volume "22" number "2" startingPage "109" endingPage "114" publisher "Consortium for Computing Sciences in Colleges"  address "USA" is updated
    Then system will respond with "Reference updated successfully!"