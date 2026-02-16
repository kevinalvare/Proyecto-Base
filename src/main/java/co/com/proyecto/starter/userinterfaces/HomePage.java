package co.com.proyecto.starter.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    private HomePage() { /* Utility class */ }

    // Ajusta el localizador según tu aplicación real (id, css o xpath del banner "Tu año")
    public static final Target BANNER_TU_ANO = Target.the("Banner Tu Año")
            .located(By.cssSelector("[data-testid='banner-tu-ano'], .banner-tu-ano"));

    public static final Target TAB_AHORRO = Target.the("Pestaña Ahorro e Inversión")
            .located(By.cssSelector("a[data-automation-id='tab_ahorro-e-inversión']"));

    public static final Target TAB_PENSION = Target.the("Pestaña Pensión")
            .located(By.cssSelector("a[data-automation-id='tab_pensión']"));

    public static final Target TAB_CESANTIAS = Target.the("Pestaña Cesantías")
            .located(By.cssSelector("a[data-automation-id='tab_cesantias']"));
}
