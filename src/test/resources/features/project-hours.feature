Feature: project hours
  Scenario: Successfully consult the hours reamining to complete a project
    Given I accept a project thats gonna take 7000 hours to complete, worth 50000.0 and from the client "Jose Pedro"
    When I ask for the hours left on the project after 6000 hours of work
    Then the hours remaining are 1000

  Scenario: Successfully consult the hours reamining to complete a project thats already finished
    Given I accept a project thats gonna take 7000 hours to complete, worth 50000.0 and from the client "Jose Pedro"
    When I ask for the hours left on the project after 7001 hours of work
    Then the hours remaining are 0

  Scenario: Unsuccessfully consult the hours reamining to complete a project
    Given I have no projects currently
    When I ask for the hours left on the project after 100 hours of work
    Then the operation should be denied