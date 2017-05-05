Feature: User can search references according to a string

 
  Scenario: user can search all reference data for given string
    Given a book reference with key "MW341" author "Mika Waltari" title "Sinuhe" year "1934" publisher "Otava" is created successfully
    And a book reference with key "MW342" author "Kaisa Waltari" title "Sinuhe" year "1934" publisher "Otava" is created successfully
    And searchdata "Mika" is given
    When Search button is pressed
    Then book reference with data "Mika Waltari" is displayd in the list
    And system will not respond with "Kaisa Waltari"

  Scenario: user can search reference data and corresponding references not found
    Given Front page is opened
    And searchdata "yhteiskuntaperillinen" is given
    When Search button is pressed
    Then system will not respond with "yhteiskuntaperillinen"
