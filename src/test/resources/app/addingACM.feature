Feature: User can add a reference from ACM Digital Library
#
#  Scenario: user can add an article reference from ACM Digital Library
#    Given form acm is selected
#    When url "http://dl.acm.org/citation.cfm?id=2160732&CFID=931862085&CFTOKEN=88800945" is inserted
#    Then system will respond with "Reference added successfully!"
#
#
#  Scenario: user can add a book reference from ACM Digital Library
#    Given form acm is selected
#    When url "http://dl.acm.org/citation.cfm?id=2071032&CFID=931862085&CFTOKEN=88800945" is inserted
#    Then system will respond with "Reference added successfully!"
##
#  Scenario: user can add an inproceedings reference from ACM Digital Library
#    Given form acm is selected
#    When url "http://dl.acm.org/citation.cfm?id=2380552.2380613&exportformats.cfm?id=2380613" is inserted
#    Then system will respond with "Reference added successfully!"
#
#
#  Scenario: user cannot add a reference from ACM Digital Library with an empty link
#    Given form acm is selected
#    When url "" is inserted
#    Then system will respond with "Check your link!"





