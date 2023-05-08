Feature: As a user i want to get user information

  @TestCase-MPAAAC-58
  Scenario: as user i want to input valid endpoint for get user information
    Given user have endpoint auth
    When user send endpoint auth
    When user has endpoint to get user information
    And user get user information
    Then user get user information status code 200
    And I receive valid data for user info

  @TestCase-MPAAAC-59
  Scenario: as user i cannot get user information with invalid endpoint
    Given user have endpoint auth
    When user send endpoint auth
    When user has invalid endpoint to get user information
    And user get user information
    Then user get user information status code 404
