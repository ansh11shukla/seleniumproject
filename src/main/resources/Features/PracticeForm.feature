Feature: Student Register Form
  
  As a student
  I want to register into the portal
  So that i can regsiter myself

@UITEST
  Scenario Outline: Verify register form
    Given User is on registration page
    And Enter FirstName as "ANSHUL" , LastName as "SHUKLA" and Email as "anshul@mailinator.com"
    When User click on gender as "Male"
    And Enter Mobile number as "7837229425"
    And User enters "<Subject>", "Hobbies", Date and "<Address>"
    And Upload the picture
    And Select State as "NCR" and City as "Delhi"
    And Click on Submit button
    Then User should register successfully into the portal

    Examples: 
      | Subject |  | Hobbies |  | Address    |
      | Maths   |  | Sports  |  | Chandigarh |
