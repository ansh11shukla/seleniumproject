Feature: Verify search functioality
  
  As a register user on myntra
  
  i want to search a Nike Sneakers shoes
  
  So that i can buy it

  Scenario: Verify the search functionality
    Given User launches Chrome broswer 113 on window 10
    And Enter URL "https://www.myntra.com/"
    And User should login into account
    When User search "Nike Sneakers" from search bar
    Then User should see list of item on the result screen
