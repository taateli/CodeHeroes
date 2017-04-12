Feature: User can add a book reference to reference database by 

    Scenario: user can add a book reference
       Given form book is selected
       When  title "Sinuhe" authro "Mika Waltari" publisher "Otava" year "1934" are inserted
       And submit is pressed
       Then  system will respond with "new book inserted"
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