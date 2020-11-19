Feature: Users API request

  @smoke
  Scenario: Status code is 200
    Given I make a request for the users api
    Then the users api status code is 200

  Scenario: Response matches the agreed schema
    Given I make a request for the users api
    Then the users api response matches the schema

  Scenario: Header Content-type is application/json
    Given I make a request for the users api
    Then the users api content-type is application/json