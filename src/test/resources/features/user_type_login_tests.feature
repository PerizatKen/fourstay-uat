
Feature: Login functionality for different user types
  As as user, when I go to the FourStay home page,
  I should be able to login as host or guest
@login_host
  Scenario: Login as a host
    Given I am on the fourstay homepage
    When I login as a host
    Then I should be able verify I am logged in
@login_guest
  Scenario: Login as a guest
    Given I am on the fourstay homepage
    When I login as a guest
    Then I should be able verify I am logged in
    
   
