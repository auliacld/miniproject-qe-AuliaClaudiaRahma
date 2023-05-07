Feature: As a user i want to delete category product

  @DeleteCategoryProduct
  Scenario: as user i input all valid data in delete category product
    Given user set endpoint auth
    When user desc and send endpoint auth
    When user has endpoint delete endpoint category product
    And user send request for delete category product
    Then user see HTTP code 200