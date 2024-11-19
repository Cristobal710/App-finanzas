Feature: project Return Of investment

  Scenario: Successfully calculate the ROI of a project
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    And the final gaining of the project is 150000.0
    When I ask for the ROI of said project
    Then the ROI of the project is 10000.0

  Scenario: Successfully calculate the ROI of a project
    Given I accept a project thats gonna take 700 hours to complete, worth 150000.0 and from the client "Jose Pedro"
    And the final gaining of the project is 140000.0
    When I ask for the ROI of said project
    Then the ROI of the project is -10000.0

  Scenario: Successfully calculate the ROI of a project
    Given I accept a project thats gonna take 700 hours to complete, worth 150000.0 and from the client "Jose Pedro"
    And the final gaining of the project is 150000.0
    When I ask for the ROI of said project
    Then the ROI of the project is 0.0

  Scenario: Unsuccessfully calculate the ROI of a project
    Given I have no projects currently
    When I ask for the ROI of said project
    Then the operation should be denied