Feature: As a user i want to create new user register

  @TestCase-MPAAAC-55
  Scenario: as user i input all valid data in post new user register
    Given user has endpoint post new user register
    When user send post new user register
    Then user get status code 200
    And I receive valid data for new register

  @TestCase-MPAAAC-56
  Scenario: as user i cannot create new user with invalid endpoint
    Given user has invalid endpoint for create new user register
    When user send post new user register
    Then user get status code 400
