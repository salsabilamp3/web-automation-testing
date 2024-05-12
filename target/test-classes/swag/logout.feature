Feature: User Logout
  As a user
  I want to be able to logout from my account
  So that I can securely exit my session

  Scenario: Successful logout
    Given I am logged in and on the dashboard page
    When I press the logout button
    Then I should be navigated back to the login page
