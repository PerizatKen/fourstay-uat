@STAYTEST_37
Feature: Search results lists property 
that is unavailable on searching date

Scenario: As a user I should be able to search 
stay for the a specified date range 
So that the result lists only stays 
that are available of those days

Given Navigate to the home page of the fourstay application
When Input search criteria, specify date in "03/01/2018" and date out "03/02/2018" 
Then Result page should will give a list of stays that meet searching criteria
 
