Feature: As a user i want to get detail all orders

  @GetUserAllOrders
  Scenario: as user i input all valid data in get detail all orders
    Given user has endpoint auth
    When user can send endpoint auth
    When user has endpoint to get all orders
    And user get detail all orders
    Then user get user detail all orders with status code 200
