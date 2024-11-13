Feature: Employee information

    Scenario: Successfully ask for the information of a employee
        Given a employee who's name is "Pepe Sand", role is "junior" and costs 500.0 per hour
        When I ask for the report of the employee "Pepe Sand"
        Then the report should say the employee "Pepe Sand" costs 500.0 per hour 

    Scenario: Unsuccessfully ask for the information of a employee
        Given a employee who's name is "Pepe Sand", role is "junior" and costs 500.0 per hour
        When I ask for the report of the employee "Laucha Acosta"
        Then the operation should be denied