
Feature: Verifying Amazon's FaceBook profile name
 

 @FaceBookLogin
  Scenario: Checking amazon's facebook profile
    Given I landed on landing page
    And Going to facebook login page
    When Iterating window
    Then "Amazon India" is correct
    

 