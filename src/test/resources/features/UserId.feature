Feature: User Id API request

  @smoke
  Scenario: Status code is 200
    Given I make a valid request for the user id api
    Then the user id api status code is 200

  @smoke
  Scenario: Status code is 404
    Given I make an invalid request for the user id api
    Then the user id api status code is 404

  Scenario Outline: Response matches the agreed schema
    Given I make a request for the user <userId>
    Then the user id api response matches the schema
    Examples:
    | userId |
    | 1      |
    | 2      |
    | 3      |
    | 4      |
    | 5      |


  Scenario: Header Content-type is application/json
    Given I make a valid request for the user id api
    Then the user id api content-type is application/json