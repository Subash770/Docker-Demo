Feature: User API

  Scenario Outline: Create a new user
    When I create a new user with name "<name>" and email "<email>"
    Then the user should be created with name "<name>" and email "<email>"

    Examples:
      | name        | email                  |
      | JohnDoe     | johndoe@example.com    |
      | JaneSmith   | janesmith@example.com  |
      | AliceJones  | alice.jones@example.com|
