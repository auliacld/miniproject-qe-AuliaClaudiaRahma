Feature: As a user i want to get index

  @GetIndex
  Scenario: as user i input all valid data in get all index
    Given user has endpoint index
    When user send request get detail index
    Then user get index status code 200