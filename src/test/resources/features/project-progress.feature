Feature: project billing in advance
  Scenario: Successfully charge the client for some of the work of the project
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    And its a project of deed
    When I charge the client 350 hours into the project for the work done
    Then the bill should be of 70000.0 and the hours remaining should be 350

  Scenario: Unsuccessfully charge the client for some of the work of the project thats not a project of deed
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    When I charge the client 350 hours into the project for the work done
    Then the operation should be denied