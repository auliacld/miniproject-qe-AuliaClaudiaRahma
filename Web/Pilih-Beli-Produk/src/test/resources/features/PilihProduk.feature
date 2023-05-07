Feature: As a user i have choose product so that i can order product

  @TestCaseMPAAAC-14
  Scenario: as user i want to choose product and add product to cart
    Given user on login page
    When user input valid email
    And user input valid password
    And user click login button
    And user on products page
    When  user click button Beli
    And user click cart
    Then the product has been successfully selected

  @TestCaseMPAAAC-15
  Scenario: as user i can see detail product
    Given user on login page
    When user input valid email
    And user input valid password
    And user click login button
    And user on products page
    When user click button Detail
    Then user can see detail product

  @TestCaseMPAAAC-16
  Scenario: as user i want to order and pay product
    Given user on login page
    When user input valid email
    And user input valid password
    And user click login button
    And user on products page
    When  user click button Beli
    And user click cart
    And user click Bayar
    Then the order has been successfully and user see history transactions