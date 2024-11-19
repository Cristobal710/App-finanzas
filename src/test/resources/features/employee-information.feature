Feature: Employee information

  Scenario: Successfully ask for the information of a junior developer
    Given a employee who's name is "Pepe Sand", role is "Junior", has dni 876421 and his activity is "Desarrollador"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 500.0 per hour

  Scenario: Successfully ask for the information of a senior developer
    Given a employee who's name is "Pepe Sand", role is "Senior", has dni 876421 and his activity is "Desarrollador"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 1000.0 per hour

  Scenario: Successfully ask for the information of a semi-senior developer
    Given a employee who's name is "Pepe Sand", role is "Semi-Senior", has dni 876421 and his activity is "Desarrollador"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 750.0 per hour

  Scenario: Successfully ask for the information of a junior analist
    Given a employee who's name is "Pepe Sand", role is "Junior", has dni 876421 and his activity is "Analista"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 1000.0 per hour


  Scenario: Successfully ask for the information of a senior analist
    Given a employee who's name is "Pepe Sand", role is "Senior", has dni 876421 and his activity is "Analista"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 1500.0 per hour

  Scenario: Successfully ask for the information of a semi-senior analist
    Given a employee who's name is "Pepe Sand", role is "Semi-Senior", has dni 876421 and his activity is "Analista"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" costs 1200.0 per hour

  Scenario: Unsuccessfully ask for the information of a employee
    Given a employee who's name is "Pepe Sand", role is "Junior", has dni 876421 and his activity is "Analista"
    When I ask for the report of the employee "Laucha Acosta"
    Then the operation should be denied