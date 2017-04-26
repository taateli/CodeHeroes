Feature: User can add an article reference to reference database by filling mandatory fields

Scenario: user can add an article reference with mandatory fields filled
    Given form article is selected
    When key "KW04" author "Whittington, Keith J." title "Infusing active learning into introductory programming courses" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite" are inserted
    Then system will respond with "Reference added successfully!"
 
Scenario: user can add an article reference with two authors and mandatory fields filled
    Given form article is selected
    When key "KW05" author "Whittington, Keith J. and Satu" title "Again, infusing active learning into introductory programming courses" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite" are inserted
    Then system will respond with "Reference added successfully!"

Scenario: user can add an article reference with several authors and mandatory fields filled
    Given form article is selected
    When key "KW08" author "Kaisa and Whittington, Keith J. and Satu" title "Infusing active learning into introductory programming courses once more" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite" are inserted
    Then system will respond with "Reference added successfully!"

  Scenario: user cannot add an article reference without mandatory fields filled
    Given form article is selected
    When key "KW06" author "" title "Infusing active learning into introductory programming courses" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite" are inserted
    Then system will respond with "Field can not be empty!"

Scenario: user cannot add an article reference without mandatory fied title
    Given form article is selected
    When key "KW07" author "Whittington, Keith J." title "" year "2017" journal "J. Comput. Small Coll." publisher "publisher" volume "19" number "3" startingPage "3" endingPage "6" month "5" address "katuosoite" are inserted
    Then system will respond with "Field can not be empty!"


# Pari pidempää versiota
#     Scenario: user can add an article reference with mandatory fields filled
#        Given form article is selected
#        When key "KW04" author "Whittington, Keith J." title "Infusing active learning into introductory programming courses"  journal "J. Comput. Small Coll." volume "19" number "5" year "2004" startingPage "249" endingPage "259" publisher "Consortium for Computing Sciences in Colleges" are inserted
#        Then system will respond with "Reference added succesfully!"
#
#     Scenario: user cannot add an article reference without mandatory fields filled
#        Given form article is selected
#        When key "KW04" author "" title "Infusing active learning into introductory programming courses"  journal "J. Comput. Small Coll." volume "19" number "5" year "2004" startingPage "249" endingPage "259" publisher "Consortium for Computing Sciences in Colleges" are inserted
#        Then system will respond with "Field can not be empty!"