package co.com.proyecto.starter.userinterfaces.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Pim {
    public static Performable about() {
        return Task.where("{0} searches for '" + "searchTerm" + "'",
                Click.on(Home.PIM).afterWaitingUntilPresent(),
                Click.on(Home.ADD).afterWaitingUntilPresent()
        );
    }
}
