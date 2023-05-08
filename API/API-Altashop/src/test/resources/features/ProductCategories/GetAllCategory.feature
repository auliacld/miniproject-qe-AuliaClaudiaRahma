Feature: As a user i want to get all detail category

  @TestCase-MPAAAC-67
  Scenario: as user i want to send to valid endpoint for get all detail category
    Given user has endpoint to get detail category
    When user get all detail category
    Then user get category status code 200
    And I receive valid data for all category

  @TestCase-MPAAAC-68
  Scenario: as user i cannot get all detail category cause invalid endpoint
    Given user has invalid endpoint for get detail category
    When user get all detail category
    Then user see HTTP respon code 404
