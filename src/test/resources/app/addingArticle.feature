Feature: User can add an article reference to reference database by filling mandatory fields

     Scenario: user can add an article reference with mandatory fields filled
        Given form article is selected
        When key "KW04" author "Whittington, Keith J." title "Infusing active learning into introductory programming courses"  journal "J. Comput. Small Coll." volume "19" year "2004" are inserted
        Then system will respond with "Reference added succesfully!"

     Scenario: user cannot add an article reference without mandatory fields filled
        Given form article is selected
        When key "KW04" author "" title "Infusing active learning into introductory programming courses"  journal "J. Comput. Small Coll." volume "19" year "2004" are inserted
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
