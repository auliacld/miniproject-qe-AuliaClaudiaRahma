Feature: As a user i want to delete category product

  @TestCase-MPAAAC-69
  Scenario: as user i want to input valid endpoint for delete category product
    Given user set endpoint auth
    When user desc and send endpoint auth
    When user has endpoint delete endpoint category product
    And user send request for delete category product
    Then user see HTTP code 200

  @TestCase-MPAAAC-70
  Scenario: as user i cannot delete category product cause invalid endpoint
    Given user set endpoint auth
    When user desc and send endpoint auth
    When user has invalid endpoint for delete endpoint category product
    And user send request for delete category product
    Then user see HTTP respon code 404