Feature: As an user, I want to success login and success register, So that i can see my home page

  @TestCase-LoginWrongValue
  Scenario: As an user, i cannot login because wrong email or password
    Given user on the login page
    When user input "yulastari74@gmail.com" on email field
    And user input "password" on password field
    And user click login button
    Then user see error message "Wrong Email or Password"

  @TestCase-LoginValidValue
  Scenario:  As an user, i can login with a valid email and valid password
    Given user on the login page
    When user input "aulia@gmail.com" on email field
    And user input "Ridwan123" on password field
    And user click login button
    Then user see home page

  @TestCase-RegisterValidValue
  Scenario:  As an user, i can register with a valid value
    Given user on the login page
    When user click Create One button
    And user input name "Aulia" on name field
    And user input email "aulia@dummy.com" on email field
    And user input password "123456" on password field
    And user input confirm password "123456" on confirm password field
    And user click register button
    Then user see validate message "Registration Successful"

  @TestCase-RegisterEmptyName
  Scenario:  As an user, i cannot register because empty name field
    Given user on the login page
    When user click Create One button
    And user input name " " on name field
    And user input email "aulia@dummy.com" on email field
    And user input password "123456" on password field
    And user input confirm password "123456" on confirm password field
    And user click register button
    Then user see error alert message "Enter Full Name"

  @TestCase-RegisterEmptyEmail
  Scenario:  As an user, i cannot register because empty email field
    Given user on the login page
    When user click Create One button
    And user input name "aulia" on name field
    And user input email " " on email field
    And user input password "123456" on password field
    And user input confirm password "123456" on confirm password field
    And user click register button
    Then user see alert message "Enter Valid Email"



