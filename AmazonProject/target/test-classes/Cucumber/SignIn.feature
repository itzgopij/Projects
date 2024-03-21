
Feature: SignIn with different accounts and verifying error message
  
  Background:
  Given I landed on landing page 
  
  @SignIn
  Scenario Outline: Login with different login credentials
    Given Click on signIn button
    When Login with username <username> and password <password>
    Then "Your password is incorrect" message is displayed

    Examples: 
      |username              | password       |
      | amazon@gmail.com     | amazon123      |
      | amazon5012@gmail.com |  amazon5012    |

      
     