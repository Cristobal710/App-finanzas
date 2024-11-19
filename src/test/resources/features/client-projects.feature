Feature: Clients projects
  Scenario: Successfully ask for a clients project's
    Given a client with name "Pepe" and 2 projects currently being done for him
    When I ask for the projects that the client "Pepe" has
    Then there should be 2 projects at his name

  Scenario: Successfully ask for a clients project's with no projects
    Given a client with name "Pepe Mujica" and 0 projects currently being done for him
    When I ask for the projects that the client "Pepe Mujica" has
    Then there should be 0 projects at his name

  Scenario: Unsuccessfully ask for a clients project's
    Given a client with name "Pepe" and 2 projects currently being done for him
    When I ask for the projects that the client "Juan" has
    Then the operation should be denied

  Scenario: Successfully ask for the state of a project
    Given a client with name "Pepe Mujica" and 2 projects currently being done for him
    And one of them is delayed
    When I ask for the projects that the client "Pepe Mujica" has
    Then there should be 2 projects at his name and 1 should be delayed