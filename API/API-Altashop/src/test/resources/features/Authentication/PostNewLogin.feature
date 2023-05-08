Feature: As a user i want to create new user login

  @TestCase-MPAAAC-51
  Scenario: as user i want to input valid endpoint for create new user login
    Given user has endpoint post new user login
    When user send request for create new user login
    Then login user get status code 200
    And I receive valid data for new login

  @TestCase-MPAAAC-52
  Scenario: as user cannot create new user login cause invalid endpoint
    Given user has invalid endpoint for create new user login
    When user send request for create new user login
    Then login user get status code 404
