Feature: project Return Of investment

  Scenario: Successfully calculate the ROI of a project
    Given a project that gave 1000.0 on gainings and costs 500.0
    When I ask for the ROI of said project
    Then the ROI of the project is 500.0

  Scenario: Successfully calculate the ROI of a project
    Given a project that gave 1000.0 on gainings and costs 1500.0
    When I ask for the ROI of said project
    Then the ROI of the project is -500.0

  Scenario: Successfully calculate the ROI of a project
    Given a project that gave 1000.0 on gainings and costs 1000.0
    When I ask for the ROI of said project
    Then the ROI of the project is 0.0

  Scenario: Unsuccessfully calculate the ROI of a project
    Given a project that hasn't finished
    When I ask for the ROI of said project
    Then the operation should be denied