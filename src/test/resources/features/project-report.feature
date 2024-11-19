Feature: project report
  Scenario: Successfully ask for the monthly report of a project
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    When I ask for the monthly report after the first month has finished and 2 people are working on the project
    Then the report should say the project's monthly cost is of 64000.0

  Scenario: Unsuccessfully ask for the monthly report of a project
    Given I have no projects currently
    When I ask for the monthly report after the first month has finished and 2 people are working on the project
    Then the operation should be denied