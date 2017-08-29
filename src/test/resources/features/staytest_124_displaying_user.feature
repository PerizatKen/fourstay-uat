
Feature: Diplaying user information 

Background:
Given I am on the fourstay login dialog

Scenario: Verify host user information 
	Given I am on the fourstay login dialog 
	And I enter email "testscooper@test.mail.com" 
	#And I enter email "kuzzattest@test.mail.com" =>example to see other option
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Sheldon Cooper"
	
	Scenario: Verify guest user information 
	Given I am on the fourstay login dialog 
	And I enter email "testafowler@test.mail.com" 
	And I enter password "password" 
	When I click on the login button 
	Then the user name should be "Amy Fowler"
	
	@Staytest_124 
	Scenario Outline: Verify guest user information 
	Given I am on the fourstay login dialog 
	And I enter email "<email>" 
	And I enter password "<password>" 
	When I click on the login button 
	Then the user name should be "<name>"
	Examples:
	|       email                  |   password    |     name        |
	#| testafowler@test.mail.com    |   password    |  Amy Fowler     |
	#| OrlandoWolf@test.mail.com    | Orlandob74cf  | Orlando Wolf    |
	| LenoraFerry@test.mail.com    |  Lenoradb1d1   |Lenora	Ferry    |
	#| CharlotteHeller@test.mail.com| Charlotte6b8a2| Charlotte Heller|
	
	
	
