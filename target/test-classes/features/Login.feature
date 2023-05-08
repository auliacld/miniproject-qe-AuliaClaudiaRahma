Feature: As a user i have be able to success login so that i can see main page

  @TestCaseMPAAAC-8
  Scenario: as user i want to input valid to then i can see success login
    Given user on login page
    When user input valid email
    And user input valid password
    And user click login button
    Then user on products page

  @TestCaseMPAAAC-7
  Scenario: as user i want to input invalid email then get error message
    Given user on login page
    When user input invalid username
    And user input valid password
    And user click login button
    Then user see error message

  @TestCaseMPAAAC-6
  Scenario: as user i want to input empty email then get error message
    Given user on login page
    When user input empty email
    And user input valid password
    And user click login button
    Then user see error message

  @TestCaseMPAAAC-11
  Scenario: as user i want to input empty password then get error message
    Given user on login page
    When user input valid email
    And user input empty password
    And user click login button
    Then user see error message