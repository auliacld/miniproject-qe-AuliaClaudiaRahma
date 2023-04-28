Feature: As a user i have be able to success register so that i can see login page

  @TestCaseMPAAAC-5
  Scenario: as user i want to register with correct values
    Given user on register page
    When user input valid complete name
    And user input valid email
    And user input valid password
    And user click login button
    Then user on login page

  @TestCaseMPAAAC-4
  Scenario: as user i want to register with using existing email
    Given user on register page
    When user input valid complete name
    And user input existing email
    And user input valid password
    And user click login button
    Then user see error message

  @TestCaseMPAAAC-2
  Scenario: as user i want to register with empty complete name value
    Given user on register page
    When user input empty complete name
    And user input valid email
    And user input valid password
    And user click login button
    Then user see error message

  @TestCaseMPAAAC-10
  Scenario: as user i want to register with empty email value
    Given user on register page
    When user input valid complete name
    And user input empty email
    And user input valid password
    And user click login button
    Then user see error message

  @TestCaseMPAAAC-11
  Scenario: as user i want to register with empty password value
    Given user on register page
    When user input valid complete name
    And user input valid email
    And user input empty password
    And user click login button
    Then user see error message
