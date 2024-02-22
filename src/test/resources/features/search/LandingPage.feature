Feature: Landing Page


  @dev
  Scenario: Forgot Password Flow
    Given Sergey opens EliteSingle(US)
    When he wants to reset his password
    Then he enters email "test@gmail.com"


#  @qa
#  Scenario: Searching for 'green'
#    Given Sergey is researching things on the internet
#    When he looks up "green"
#    Then he should see information about "green"
