Feature: Registro de empleados en OrangeHRM
  Como admin de RRHH
  Quiero registrar un nuevo empleado con credenciales de acceso
  Para que el empleado aparezca en la lista de PIM

  @orangehrm @pim @employee
  Scenario: Registrar un nuevo empleado y verificarlo en PIM
    Given el usuario inicia sesion en OrangeHRM con usuario "Admin" y clave "admin123"
    When el usuario registra al empleado con datos generados
    And el usuario abre el modulo PIM y busca el empleado generado
    Then el empleado generado debe aparecer en los resultados
