Feature: project consultant
  Scenario: Successfully consult the gainings of a project thats making a profit
    Given a project thats making 200.0 on profit
    When I ask for the state of the project
    Then the profit of said project should be 200.0

    Scenario: Successfully consult the gainings of a project thats not making profit
    Given a project thats making -200.0 on profit
    When I ask for the state of the project
    Then the profit of said project should be -200.0

    Scenario: Unsuccessfully consult the gainings of a project thats making a profit
    Given I have no projects currently
    When I ask for the state of the project
    Then the operation should be denied

    
    
    
    