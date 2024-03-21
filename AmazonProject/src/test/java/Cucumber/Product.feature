

Feature: Selecting product and verifying PageTitle
  


  @Product
  Scenario: Verifying PageTitle with product name 
    Given I landed on landing page
    And Searching desired product
    When Selecting the product 
    And Iterating the window
    Then I validate the pageTitle with productName
   

  