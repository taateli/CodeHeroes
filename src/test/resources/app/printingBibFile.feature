Feature: User can enter name and print bib file

  Scenario: user can give name and print bib file 
    Given filename "tiedosto" is added
    When printFile button is pressed
    Then file is created by name "tiedosto" 

