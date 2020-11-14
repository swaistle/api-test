Feature: Users API request

  Scenario: Status code is 200
    Given the users api status code is 200

  Scenario: Response matches the agreed schema
    Given the users api response matches the schema

  Scenario: Header Content-type is application/json
    Given the users api content-type is application/json