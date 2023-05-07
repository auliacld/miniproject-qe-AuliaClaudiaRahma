Feature: As a user i want to create new comment for product

  @PostNewCommentProduct
  Scenario: as user i input all valid data in post new comment for product
    Given user Own endpoint auth
    When user Clarify and send endpoint auth
    When user has endpoint create new comment for product
    And user send request for create new comment for product
    Then user can see http response code 200
    And I receive valid data for product comment