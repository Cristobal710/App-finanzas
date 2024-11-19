Feature: Employee registration

  Scenario: Successfully register an employee
    Given a employee who's name is "Pepe Sand", role is "junior", has dni 876421 and his activity is "Desarrollador"
    When I ask for the report of the employee "Pepe Sand"
    Then the report should say the employee "Pepe Sand" role is "junior" and his activity is "Desarrollador"

  Scenario: Unsuccessfully register an employee
    Given a employee who's name is "", role is "junior", has dni 876421 and his activity is "Desarrollador"
    Then the operation should be denied

  Scenario: Unsuccessfully register an employee
    Given a employee who's name is "Pepe Sand", role is "", has dni 876421 and his activity is "Desarrollador"
    Then the operation should be denied

  Scenario: Unsuccessfully register an employee
    Given a employee who's name is "Pepe Sand", role is "junior", has dni 0 and his activity is "Desarrollador"
    Then the operation should be denied

  Scenario: Unsuccessfully register an employee
    Given a employee who's name is "Pepe Sand", role is "junior", has dni 876421 and his activity is ""
    Then the operation should be denied