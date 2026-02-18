package co.com.proyecto.starter.utils;

import co.com.proyecto.starter.models.Empleado;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EmpleadoFakerTest {

    @Test
    public void debeGenerarEmpleadoConDatosBasicos() {
        EmpleadoFaker faker = new EmpleadoFaker();
        Empleado empleado = faker.generar();

        assertNotNull(empleado);
        assertNotNull(empleado.getFirstName());
        assertNotNull(empleado.getMiddleName());
        assertNotNull(empleado.getLastName());
        assertNotNull(empleado.getEmployeeUser());
        assertNotNull(empleado.getEmployeePass());
        assertNotNull(empleado.getFullName());

        assertTrue(empleado.getFullName().contains(empleado.getFirstName()));
        assertTrue(empleado.getFullName().contains(empleado.getLastName()));
    }
}

