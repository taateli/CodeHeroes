Feature: User can enter a name and print bib file

  Scenario: user can give a name and print bib file
    Given filename "tiedosto" is added
    When printFile button is pressed
    Then file is created by name "tiedosto"

  Scenario: user can leave the name empty and print bib file
    Given filename "" is added
    When printFile button is pressed
    Then file is created by name "sigproc"
