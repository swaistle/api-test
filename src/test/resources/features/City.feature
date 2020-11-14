Feature: City API request

  Scenario: Status code is 200
    Given the city api status code is 200

  Scenario: Single array response matches the agreed schema
    Given user from Kax matches the schema

  Scenario: Multiple array response matches the agreed schema
    Given users from London matches the schema

  Scenario Outline: Cities with special characters response match the agreed schema
    Given users from <city> matches the schema
    Examples:
      | city                |
      | Shi’ao              |
      | Bonneuil-sur-Marne  |
      | Caldas da Felgueira |
      | Dubova (Driloni)    |

  Scenario Outline: Cities containing non-english characters response match the agreed schema
    Given users from <city> matches the schema
    Examples:
      | city          |
      | Krzyżowice    |
      | Älvsjö        |
      | Vairão        |
      | Phú Lộc       |
      | Saint-Égrève  |
      | Aţ Ţaybah     |
      | Chợ Mới       |
      | Trần Văn Thời |
      | Gœsdorf       |
      | كاف الجاع     |

  Scenario: Empty array response matches the agreed schema
    Given user from Newcastle matches the schema

  Scenario Outline: Long city name is accepted
    Given user from <city> matches the schema
    Examples:
      | city                                                                                  |
      | Morcellemont Saint André                                                              |
      | Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu |


