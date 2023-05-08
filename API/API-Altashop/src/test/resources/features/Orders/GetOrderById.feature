Feature: As a user i want to get detail order by id

  @TestCase-MPAAAC-79
  Scenario: as user i input all valid data in get detail order by id
    Given user have Endpoint Auth
    When user  send Edpoint Auh
    When user has endpoint to get order by id
    And user get detail order by id
    Then user get detail order by id with status code 200

  @TestCase-MPAAAC-79
  Scenario: as user i input all valid data in get detail order by id
    Given user have Endpoint Auth
    When user  send Edpoint Auh
    When user has endpoint to get order by id
    And user get detail order by id
    Then user get detail order by id with status code 200
