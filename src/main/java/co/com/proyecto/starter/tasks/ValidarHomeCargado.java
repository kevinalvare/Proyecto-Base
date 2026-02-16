package co.com.proyecto.starter.tasks;

import co.com.proyecto.starter.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarHomeCargado implements Task {

    private final int timeoutSegundos;

    private ValidarHomeCargado(int timeoutSegundos) {
        this.timeoutSegundos = timeoutSegundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera a que el DOM del home esté listo verificando un elemento representativo
                WaitUntil.the(HomePage.BANNER_TU_ANO, isVisible()).forNoMoreThan(timeoutSegundos).seconds()
        );
    }

    public static ValidarHomeCargado porDefecto() {
        return new ValidarHomeCargado(30);
    }
}
