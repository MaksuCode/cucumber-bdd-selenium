Feature: Login

  Background:
    Given Mustafa is on home page
    And Mustafa has an account on Amazon

  Scenario:

    Mustafa logs in successfully

    When Mustafa logs in with his valid credentials
    Then He should be directed to home page
    And He should see his name on the navigation bar
    But He should not see log in button on the navigation bar


  Scenario:

    Mustafa can not remember his credentials :(

    When Mustafa tries to log in in with invalid credentials
    Then He could not log in
