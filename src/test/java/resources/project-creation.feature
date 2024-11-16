Feature: project creation
  Scenario: Successfully create a project
    Given I accept a project thats gonna take 7000 hours to complete, worth 50000.0 and from the client "Jose Pedro"
    Then the project should be 7000 hours remaining to complete

  Scenario: Unsuccessfully create a project
    Given I accept a project thats gonna take 0 hours to complete, worth 50000.0 and from the client "Jose Pedro"
    Then the operation should be denied

  Scenario: Unsuccessfully create a project
    Given I accept a project thats gonna take 50 hours to complete, worth 0 and from the client "Jose Pedro"
    Then the operation should be denied

  Scenario: Unsuccessfully create a project
    Given I accept a project thats gonna take 220 hours to complete, worth 50000.0 and from the client ""
    Then the operation should be denied