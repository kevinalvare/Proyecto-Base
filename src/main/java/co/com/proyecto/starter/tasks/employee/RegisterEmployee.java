package co.com.proyecto.starter.tasks.employee;

import co.com.proyecto.starter.userinterfaces.search.Home;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Actor;

public class RegisterEmployee implements Task {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String username;
    private final String password;

    public RegisterEmployee(String firstName, String middleName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Home.PIM).afterWaitingUntilPresent(),
                Click.on(Home.ADD).afterWaitingUntilPresent(),
                Enter.theValue(firstName).into(Home.PRIMER_NOMBRE),
                Enter.theValue(middleName).into(Home.SEGUNDO_NOMBRE),
                Enter.theValue(lastName).into(Home.NOMBRE),
                Click.on(Home.CREATE_LOGIN_DETAILS).afterWaitingUntilPresent(),
                Enter.theValue(username).into(Home.EMPLOYEE_USERNAME),
                Enter.theValue(password).into(Home.EMPLOYEE_PASSWORD),
                Enter.theValue(password).into(Home.EMPLOYEE_CONFIRM_PASSWORD),
                Click.on(Home.SAVE_BUTTON).afterWaitingUntilPresent()
        );
    }

    public static Performable withLoginDetails(String firstName, String middleName, String lastName,
                                               String username, String password) {
        return new RegisterEmployee(firstName, middleName, lastName, username, password);
    }
}
