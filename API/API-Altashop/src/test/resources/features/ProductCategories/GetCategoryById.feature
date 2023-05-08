Feature: As a user i want to get category by id

  @TestCase-MPAAAC-64
  Scenario: as user i want to send to valid endpoint for get category by id
    Given user has endpoint get category api
    When user set endpoint category by id
    Then user get category status code 200
    And I receive valid data for category by id

  @TestCase-MPAAAC-65
  Scenario: as user i cannot get category by id cause invalid endpoint
    Given user has invalid endpoint category by id
    When user set endpoint category by id
    Then user see HTTP respon code 404
