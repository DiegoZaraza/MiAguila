@Execution
Feature: Validate register and login process

  Scenario: Error in login proccess
    Given Navigate on zapatoca register page
    When Type special or number characters
    Then Validate name field is empty
    When Type most of fifty letters on field
    Then  Validate show message for quantity of characters