@smoke

Feature: Login Page

  Scenario: Logging in with a Goodreads account successfully
    Given I am in the login page
    When The login credentials "Aztec.Midnight@gmail.com" and "Mexica*789" are used
    Then I am in the primary page

  Scenario Outline: Logging in with a Goodreads account unsuccessfully
    Given I am in the login page
    When The login credentials "<username>" and "<password>" are used
    Then An error massage is displayed
    Examples:
      | username                 | password       |
      | Aztec.Midnight@gmail.com | asd            |
      | Aztec.Midnight@gmail.com |                |
      | asd@asd                  | Mexica.Nahuatl |
      |                          | Mexica.Nahuatl |