Feature: As a user i want to create new order

  @PostNewOrder
  Scenario: as user i input all valid data in post new order
    Given user own endpoint auth
    When user clarify and send endpoint auth
    When user has endpoint create new order
    And user send request for create new order
    Then user see http response code 200