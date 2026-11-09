Feature: user Login with different credentials

  Background: 
    Given Login page was launched

  Scenario: Valid user login
    When enter credentials "student" and "Password123"
    And login button clicked
    Then validate the success message "https://practicetestautomation.com/logged-in-successfully/"

  Scenario: inValid username
    When enter credentials "stude" and "Password123"
    And login button clicked
    Then validate the error message "Your username is invalid!"

  Scenario: inValid password
    When enter credentials "student" and "assword123"
    And login button clicked
    Then validate the error message "Your password is invalid!"

  Scenario: blank inputs
    When login button clicked
    Then validate the error message "Blank inputs!"
