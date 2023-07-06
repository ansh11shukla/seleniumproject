Feature: Verify the Login Process
  
  As a register user
  
  I want to login into the flipkart portal 
  
  So that i can purhcase some product

  Scenario: Verify the successful login into the portal with email and password
    Given User launch the Chrome Broswer 112 on window 10
    And Enter the URL "www.flipkart.com"
    And Login with Email as "Anshul@gmail.com" and Password is "Anshul@123"
    When User click on Login button
    Then User should login into the portal
    And User should land on the application Home Page
