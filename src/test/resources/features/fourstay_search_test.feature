@Search
Feature: As a user, when I go to the FourStay home page, 
I should be able to search a room in a specific date,
and place 

Scenario: Search for an available room
Given As user, I am  on the fourstay homepage
 Then I search my university Name
 And I should be able select the move in date
 And I should be able select the move out date
 When I click beds button,I should be able select the quantity of bed
 Then I should be able to see the result

