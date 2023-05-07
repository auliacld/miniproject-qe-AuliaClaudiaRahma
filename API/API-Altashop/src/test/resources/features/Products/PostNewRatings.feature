Feature: As a user i want to create new rating of products

  @TestCase-MPAAAC-109
  Scenario: as user i input all valid data in post new ratings of products
    Given user posses endpoint auth
    When user define and send endpoint auth
    When user has endpoint create new rating products
    And user send request for create new rating product
    Then user has response code 200
    And I receive valid data for new rating

  @TestCase-MPAAAC-112
  Scenario: as user i cannot create rating cause invalid endpoint
    Given user posses endpoint auth
    When user define and send endpoint auth
    When user has invalid endpoint for create new rating products
    And user send request to invalid endpoint for create new rating product
    Then user can see error code 404

  @TestCase-MPAAAC-113
  Scenario: as user i cannot create new rating product without auth
    Given user has endpoint create new rating products
    When user send request for create new rating product
    Then user has Response code 401
