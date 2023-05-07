Feature: As a user i want to create new product

  @TestCase-MPAAAC-101
  Scenario: as user i input all valid data in post new product
    Given user has endpoint post new product
    When user send post new product
    Then user see status code 200
    And I receive valid data for new product

  @TestCase-MPAAAC-103
  Scenario: as user i cannot create a new product cause invalid endpoint
    Given user has invalid endpoint new product
    When user send request to invalid endpoint product
    Then user can see error status code 404

  @TestCase-MPAAAC-116
  Scenario: as user i cannot create a new product cause invalid request
    Given user has endpoint post new product
    When user send invalid request to endpoint product
    Then user get Status Code 404
