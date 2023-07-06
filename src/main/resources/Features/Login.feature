Feature: Verify the Login Process
  
  As a register user
  
  I want to login in the facebook portal
  
  So that i can access my profile and logout

  Scenario: Verify the login functionality with valid email and password.
    Given User launches Chrome broswer 113 on window 10
    And Enter URL "https://www.facebook.com/"
    And Login with email as "ansh994@gmail.com" and password "12345"
    When User clicks on Continue button
    Then User should login into the portal
    And User should land on the application screen
