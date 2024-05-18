Feature: User Login
  As a user
  I want to be able to login to my account
  So that I can access my personalized content

  @salsabilaTest
  Scenario: Login successful with valid credentials
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  @salsabilaTest
  Scenario: Login with wrong password
    Given I am on the login page
    When I enter my username "standard_user" and password "wrongpass"
    And I click the login button
    Then I should see a message saying "Username and password do not match any user in this service!"

  @amelTest
  Scenario: Login without providing a password
    Given I am on the login page
    When I enter my username "standard_user" and password ""
    And I click the login button
    Then I should see a message saying "You need Password!"

  @amelTest
  Scenario: Login without providing username and password
    Given I am on the login page
    When I enter my username "" and password ""
    And I click the login button
    Then I should see a message saying "You need Username & Password!"
