Feature: As a user i want to get all detail product

  @TestCase-MPAAAC-95
  Scenario: as user i input all valid data in get all detail product
    Given user has endpoint
    When user get all detail product
    Then user get product status code 200
    And I receive valid data for all products

  @TestCase-MPAAAC-96
  Scenario: as user cannot get detail product because invalid endpoint
    Given user has invalid endpoint
    When user not found get detail product
    Then user get code status 404
