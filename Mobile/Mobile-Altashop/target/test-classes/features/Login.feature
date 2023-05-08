Feature: As an user, I want to success login and success register, So that i can see my home page

  @TestCase-LoginWrongValue
  Scenario: As an user, i cannot login because wrong email or password
    Given user on the main page and click button login
    When user click on email field
    And user input "yulastari74@gmail.com" on email field
    And user click on password field
    And user input "password" on password field
    And user click login button
    Then user see error message ""

  @TestCase-LoginWithEmptyEmail
  Scenario: As an user, i cannot login because empty email
    Given user on the main page and click button login
    When user input "" on email field
    And user click on password field
    And user input "password" on password field
    And user click login button
    Then user get validate message ""

  @TestCase-LoginWithEmptyPassword
  Scenario: As an user, i cannot login because empty password
    Given user on the main page and click button login
    When user click on email field
    And user input "aulia@gmail.com" on email field
    And user input "" on password field
    And user click login button
    Then user see validate message ""

  @TestCase-LoginValidValue
  Scenario:  As an user, i can login with a valid email and valid password
    Given user on the main page and click button login
    When user click on email field
    And user input "aulia@gmail.com" on email field
    And user click on password field
    And user input "aulia" on password field
    And user click login button
    Then user see home page

  @TestCase-RegisterValidValue
  Scenario:  As an user, i can register with a valid value
    Given user on the main page and click button login for register
    When user click Register button
    And user click on name field
    And user input name "Aulia" on name field
    And user click on email field
    And user input email "dummy12@gmail.com" on email field
    And user click on password field
    And user input password "aulia" on password field
    And user click register button
    Then user see home page

  @TestCase-RegisterEmptyName
  Scenario:  As an user, i cannot register because empty name field
    Given user on the main page and click button login
    When user click Register button
    And user input name "" on name field
    And user click on email field
    And user input email "aulia@dummy.com" on email field
    And user click on password field
    And user input password "123456" on password field
    And user click register button
    Then user see alert fullname message ""

  @TestCase-RegisterEmptyEmail
  Scenario:  As an user, i cannot register because empty email field
    Given user on the main page and click button login
    When user click Register button
    And user click on name field
    And user input name "aulia" on name field
    And user input email "" on email field
    And user click on password field
    And user input password "123456" on password field
    And user click register button
    Then user see alert email message ""

  @TestCase-RegisterEmptyPassword
  Scenario:  As an user, i cannot register because empty password field
    Given user on the main page and click button login
    When user click Register button
    And user click on name field
    And user input name "aulia" on name field
    And user click on email field
    And user input email "aulia99@dummy.com" on email field
    And user input password "" on password field
    And user click register button
    Then user see alert password message "password can not empty"




