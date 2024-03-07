Feature: Landing Page

  #PELI-36
  @qa
  Scenario: User able click accept T&C on clicking T&C label
    Given "Sergey" opens EliteSingle(US)
    When he clicks on the terms & conditions label
    Then the terms & conditions checkbox should be checked