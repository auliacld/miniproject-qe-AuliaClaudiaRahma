Feature: As a user i want to get detail product by id

  @TestCase-MPAAAC-98
  Scenario: as user i input all valid data in get detail product by id
    Given user has endpoint get api
    When user get detail by id
    Then user get product status code 200
    And I receive valid data for product by id

  @TestCase-MPAAAC-99
  Scenario: as user i cannot get detail product by id cause invalid endpoint
    Given user has invalid endpoint get api
    When user send request to invalid endpoint for detail by id
    Then user see Status Code 404

  @TestCase-MPAAAC-110
  Scenario: as user i cannot get detail product by id cause invalid id
    Given user has endpoint with invalid id
    When user send request to invalid id
    Then user see Status Code 404
