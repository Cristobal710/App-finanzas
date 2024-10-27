Feature: project billing in advance
    Scenario: Successfully charge the client for some of the work of the project
        Given a project of deed thats 700 hours away from finishing with an hourly fee of 200.0
        When I charge the client when 350 hours into the project for the work done 
        Then the bill should be of 70000.0

    Scenario: Unsuccessfully charge the client for some of the work of the project
        Given a regular project thats 700 hours away from finishing with an hourly fee of 200.0
        When I charge the client when 350 hours into the project for the work done 
        Then the operation should be denied