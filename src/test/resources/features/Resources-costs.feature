Feature: Calcular el costo de un recurso para un mes específico

  Scenario: Calcular el costo de un recurso con un rol específico
    Given asigno un costo para una actividad en el año "2024", mes "Febrero", la experiencia asociada "Senior", la actividad asociada "Desarrollador" con un costo de 500
    And un recurso llamado "Recurso A" con 200 horas asignadas a la actividad
    When consulto el costo del recurso llamado "Recurso A" para el año "2024", mes "Febrero"
    Then el costo total del recurso debería ser 100000

  Scenario: Calcular el costo de un recurso con otro rol
    Given asigno un costo para una actividad en el año "2025", mes "Marzo", la experiencia asociada "Junior", la actividad asociada "Tester" con un costo de 300
    And un recurso llamado "Recurso B" con 150 horas asignadas a la actividad
    When consulto el costo del recurso llamado "Recurso B" para el año "2025", mes "Marzo"
    Then el costo total del recurso debería ser 45000