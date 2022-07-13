@Execution
Feature: Validate register and login process

  Scenario: Happy path login proccess
    Given Navigate on zapatoca register page
    When Insert name of user
    And Insert first last name
    And Insert second last name
    And Select document
    And Insert id number
    And Insert email
    And Insert phone number
    And Insert password
    And Confirm password
    And Accept terms conditions
    And Click on create account
    And Click ok on alert message
