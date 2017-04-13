Feature: User can add a book reference to reference database by 

     Scenario: user can add a book reference with mandatory fields
       Given form book is selected
       When  key "MW34" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" month "12" volume "342"are inserted
       And submit is pressed
       Then  system will respond with "Reference added succesfully"
#
#    Scenario: user can not login with incorrect password
#        Given command login is selected
#        When  username "pekka" and password "asd" are entered
#        Then  system will respond with "wrong username or password"
#
#    Scenario: nonexistent user can not login to 
#        Given command login is selected
#        When  username "heikki" and password "moi" are entered
#        Then  system will respond with "wrong username or password"