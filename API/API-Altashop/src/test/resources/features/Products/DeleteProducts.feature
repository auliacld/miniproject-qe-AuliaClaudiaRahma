Feature: As a user i want to delete product

  @TestCase-MPAAAC-105
  Scenario: as user i want to input all valid data in delete product
    Given user posses Endpoint auth
    When user explain and send endpoint auth
    When user has endpoint delete endpoint product
    And user send request for delete product
    Then user see HTTP Response code 200

  @TestCase-MPAAAC-106
  Scenario: as user i want to delete product without auth
    Given user has endpoint delete endpoint product
    When user send request for delete product
    Then user see error response code 401

  @TestCase-MPAAAC-107
  Scenario: as user i cannot delete product cause invalid endpoint
    Given user posses Endpoint auth
    When user explain and send endpoint auth
    When user has invalid endpoint delete endpoint product
    And user send request to invalid endpoint delete product
    Then user see error Response code 404

  @TestCase-MPAAAC-108
  Scenario: as user i cannot delete product cause not found id product
    Given user posses Endpoint auth
    When user explain and send endpoint auth
    When user set endpoint product with invalid id
    And user send request for delete product with invalid id
    Then user see error Response code 404
