Feature: Calcular el costo de un proyecto para un mes específico


  Scenario: Calcular el costo del proyecto con un rol
    Given cargo un costo para una actividad en el año "2024", mes "Febrero", la experiencia asociada "Senior", la actividad asociada "Desarrollador" con un costo de 500
    And  un proyecto "Proyecto1" con 200 horas asociadas a la actividad
    When consulto el costo de "Proyecto1" para el año "2024", mes "Febrero"
    Then el costo total del proyecto debería ser 100000

  Scenario: Calcular el costo del proyecto con otro rol
    Given cargo un costo para una actividad en el año "2025", mes "Marzo", la experiencia asociada "Junior", la actividad asociada "Tester" con un costo de 300
    And un proyecto "Proyecto2" con 150 horas asociadas a la actividad
    When consulto el costo de "Proyecto2" para el año "2025", mes "Marzo"
    Then el costo total del proyecto debería ser 45000