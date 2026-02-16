package co.com.proyecto.starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenSite implements Task {

    private static String url;

    public static OpenSite abrir(String application) {
        url = application;
        return Tasks.instrumented(OpenSite.class);
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
