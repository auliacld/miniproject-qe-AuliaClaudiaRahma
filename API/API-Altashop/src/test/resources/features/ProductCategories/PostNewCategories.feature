Feature: As a user i want to create new category

  @TestCase-MPAAAC-61
  Scenario: as user i want to send request to valid endpoint for create new category
    Given user has endpoint post new category
    When user send request for create new category
    Then user see status code 200
    And I receive valid data for new category

  @TestCase-MPAAAC-62
  Scenario: as user i cannot create new category with invalid endpoint
    Given user has invalid endpoint for create new category
    When user send request for create new category
    Then user see status code 400
