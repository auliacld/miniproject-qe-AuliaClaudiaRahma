Feature: As a user i want to get detail all orders

  @TestCase-MPAAAC-73
  Scenario: as user i want to input valid endpoint for get all detail order
    Given user has endpoint auth
    When user can send endpoint auth
    When user has endpoint to get all orders
    And user get detail all orders
    Then user get user detail all orders with status code 200

  @TestCase-MPAAAC-74
  Scenario: as user i cannot get all detail order with invalid endpoint
    Given user has endpoint auth
    When user can send endpoint auth
    When user has invalid endpoint for get all orders
    And user get detail all orders
    Then user see status code 404
