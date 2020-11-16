Feature: Instructions API request

  @smoke
  Scenario: Status code is 200
    Given the instructions api status code is 200

  Scenario: Response is as expected
    Given the instructions api response is as expected

  Scenario: Response matches the agreed schema
    Given the instructions api response matches the schema

  Scenario: Header Content-type is application/json
    Given the instructions api content-type is application/json