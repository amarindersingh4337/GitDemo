
@tag
Feature: purchase an order on ecommerce website
  I want to use this template for my feature file

	Background: 
	Given I landed on the Ecommerce Page
	
  @Regression
  Scenario Outline: Positive test of purchasing the order
    Given Logged in with username <name> and password <password>
    When I add <productName> to cart
    And Checkout <productName> and submit the order
    Then "Thankyou for the order" is displayed on confirmation page

    Examples: 
      | name  									| password 				|productName	|
      | rahulshettyacademy.com 	|     Iamking@00 	|ZARA COAT 3	|
