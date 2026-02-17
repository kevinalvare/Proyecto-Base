package co.com.proyecto.starter.tasks.employee;

import co.com.proyecto.starter.userinterfaces.search.Home;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchEmployeeInPim {
    public static Performable byName(String fullName) {
        return Task.where("{0} searches an employee in PIM",
                Click.on(Home.PIM).afterWaitingUntilPresent(),
                WaitUntil.the(Home.EMPLOYEE_NAME_SEARCH, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(Home.EMPLOYEE_NAME_SEARCH, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(Home.EMPLOYEE_NAME_SEARCH),
                Enter.theValue(fullName).into(Home.EMPLOYEE_NAME_SEARCH),
                Click.on(Home.SEARCH_BUTTON).afterWaitingUntilPresent()
        );
    }
}
