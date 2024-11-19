Feature: project consultant
  Scenario: Successfully consult the gainings of a project thats making a profit
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    And its making 80000.0 on profit up until that point
    When I ask for the state of the project 350 hours into the project
    Then the profit of said project should be 10000.0

  Scenario: Successfully consult the gainings of a project thats not making profit
    Given I accept a project thats gonna take 700 hours to complete, worth 140000.0 and from the client "Jose Pedro"
    And its making 60000.0 on profit up until that point
    When I ask for the state of the project 350 hours into the project
    Then the profit of said project should be -10000.0

  Scenario: Unsuccessfully consult the gainings of a project thats making a profit
    Given I have no projects currently
    When I ask for the state of the project 350 hours into the project
    Then the operation should be denied