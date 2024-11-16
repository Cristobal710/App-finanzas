Feature: project hours
  Scenario: Successfully consult the hours reamining to complete a project
    Given a project thats 700 hours away from finishing
    When I ask for the hours left on the project
    Then the hours reamining are 700

  Scenario: Successfully consult the hours reamining to complete a project thats already finished
    Given a project thats finished
    When I ask for the hours left on the project
    Then the hours reamining are 0

  Scenario: Unsuccessfully consult the hours reamining to complete a project
    Given I have no projects currently
    When I ask for the hours left on the project
    Then the operation should be denied