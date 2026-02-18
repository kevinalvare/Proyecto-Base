package co.com.proyecto.starter.utils;

import co.com.proyecto.starter.models.Empleado;
import com.github.javafaker.Faker;

import java.util.Locale;

public class EmpleadoFaker {
    private final Faker faker;

    public EmpleadoFaker() {
        this.faker = new Faker(new Locale("es"));
    }

    public Empleado generar() {
        String firstName = faker.name().firstName();
        String middleName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String employeeUser = String.format("%s.%s%d",
                firstName.toLowerCase(Locale.ROOT),
                lastName.toLowerCase(Locale.ROOT),
                faker.number().numberBetween(10, 99));
        String employeePass = "admin123";

        Empleado empleado = new Empleado();
        empleado.setFirstName(firstName);
        empleado.setMiddleName(middleName);
        empleado.setLastName(lastName);
        empleado.setEmployeeUser(employeeUser);
        empleado.setEmployeePass(employeePass);
        empleado.setFullName(firstName + " " + lastName);
        return empleado;
    }
}
