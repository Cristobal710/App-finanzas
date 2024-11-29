Feature: Cargar costos para actividades en un año y día específico

  Scenario: Cargar costos para una actividad en un mes específico
    Given cargo un costo para una actividad en el año "2024", mes "Enero", la experiencia asociada "Senior", la actividad asociada "Desarrollador" y un costo de 500
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Enero" y se obtienen 200 horas
    Then el costo de la actividad debería ser 100000

  Scenario: Cargar costos para una actividad en el mes de febrero
    Given cargo un costo para una actividad en el año "2024", mes "Febrero", la experiencia asociada "Senior", la actividad asociada "Desarrollador" y un costo de 500
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Febrero" y se obtienen 180 horas
    Then el costo de la actividad debería ser 90000

  Scenario: Cargar costos para una actividad con experiencia Junior en el mes de enero
    Given cargo un costo para una actividad en el año "2024", mes "Enero", la experiencia asociada "Junior", la actividad asociada "Desarrollador" y un costo de 300
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Enero" y se obtienen 200 horas
    Then el costo de la actividad debería ser 60000

  Scenario: Cargar costos para una actividad con experiencia Junior en el mes de febrero
    Given cargo un costo para una actividad en el año "2024", mes "Febrero", la experiencia asociada "Junior", la actividad asociada "Desarrollador" y un costo de 300
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Febrero" y se obtienen 180 horas
    Then el costo de la actividad debería ser 54000

  Scenario: Cargar costos para una actividad "Analista" en el mes de enero
    Given cargo un costo para una actividad en el año "2024", mes "Enero", la experiencia asociada "Senior", la actividad asociada "Analista" y un costo de 400
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Enero" y se obtienen 200 horas
    Then el costo de la actividad debería ser 80000

  Scenario: Cargar costos para una actividad "Analista" en el mes de febrero
    Given cargo un costo para una actividad en el año "2024", mes "Febrero", la experiencia asociada "Senior", la actividad asociada "Analista" y un costo de 400
    When se consulta la cantidad de horas registradas para ese Rol en el año "2024" y mes "Febrero" y se obtienen 180 horas
    Then el costo de la actividad debería ser 72000
