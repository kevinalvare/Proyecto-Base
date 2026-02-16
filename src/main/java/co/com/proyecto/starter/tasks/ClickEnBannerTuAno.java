package co.com.proyecto.starter.tasks;

import co.com.proyecto.starter.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

public class ClickEnBannerTuAno implements Task {

    private ClickEnBannerTuAno() {
        // Constructor por defecto
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Solo hacer clic si el elemento es visible/presente; en caso contrario, continuar sin error
        actor.attemptsTo(
                Check.whether(HomePage.BANNER_TU_ANO.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePage.BANNER_TU_ANO))
        );
    }

    public static ClickEnBannerTuAno porDefecto() {
        return new ClickEnBannerTuAno();
    }
}
