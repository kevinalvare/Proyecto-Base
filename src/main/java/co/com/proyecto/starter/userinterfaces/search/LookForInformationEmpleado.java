package co.com.proyecto.starter.userinterfaces.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformationEmpleado {
    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(Home.PRIMER_NOMBRE)
                        .thenHit(Keys.ENTER),
                Enter.theValue(searchTerm)
                        .into(Home.SEGUNDO_NOMBRE)
                        .thenHit(Keys.ENTER),
                Enter.theValue(searchTerm)
                        .into(Home.NOMBRE)
                        .thenHit(Keys.ENTER),
                Click.on(Home.CHECK).afterWaitingUntilPresent()
        );
    }
}
