Feature: Registro de empleados en OrangeHRM
  Como admin de RRHH
  Quiero registrar un nuevo empleado con credenciales de acceso
  Para que el empleado aparezca en la lista de PIM

  @orangehrm @pim @employee
  Scenario Outline: Registrar un nuevo empleado y verificarlo en PIM
    Given el usuario inicia sesion en OrangeHRM con usuario "<username>" y clave "<password>"
    When el usuario registra al empleado "<firstName>" "<middleName>" "<lastName>" con login "<employeeUser>" y clave "<employeePass>"
    And el usuario abre el modulo PIM y busca "<fullName>"
    Then el empleado "<fullName>" debe aparecer en los resultados

    Examples:
      | username | password | firstName | middleName | lastName | employeeUser  | employeePass | fullName      |
      | Admin    | admin123 | Kevin     |            | Alvarez  | kevin.alvarez | Admin123!    | Kevin Alvarez |

