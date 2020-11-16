Feature: User Id API request

  @smoke
  Scenario: Status code is 200
    Given the user id api status code is 200

  @smoke
  Scenario: Status code is 404
    Given the user id api status code is 404

  Scenario: Response matches the agreed schema
    Given the user id api response matches the schema

  Scenario: Header Content-type is application/json
    Given the user id api content-type is application/json