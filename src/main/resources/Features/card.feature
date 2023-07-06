Feature: Verify Add to Cart process
  
  as a register user
  
  i want to place a order 
  
  so that i can buy it
  
  Background: User launches chrome broswer
  And Enter url "https://www.myntra.com/"
  And logged into myntra account

  Scenario: Verify functionality of add to cart
    Given User searches "Addidas Shoe" on Home screen
 And User see result related "addidas shoe"
 And User click first result from result screen 
 And User should redirected to Product detail screen
 When User click on "Add to cart" button 
 Then Product should be moved to cart 