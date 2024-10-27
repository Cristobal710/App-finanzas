Feature: project report
    Scenario: Successfully ask for the monthly report of a project
        Given a project thats 3 months away from finishing and its costing 200.0 on labour monthly
        When I ask for the monthly report after the first month has finished 
        Then the report should say the project's cost is 200.0 
    
    Scenario: Successfully ask for the monthly report of a project thats already finished
        Given a project that has already finished and the total cost of it is 100000.0
        When I ask for the monthly report  
        Then the report should say the project's cost is 100000.0

    Scenario: Unsuccessfully ask for the monthly report of a project
        Given there arent any projects currently under work
        When I ask for the monthly report  
        Then the operation should be denied 

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