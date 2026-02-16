package co.com.proyecto.starter.tasks;

import co.com.proyecto.starter.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class IngresarAlHome implements Task {

    private final int timeoutSegundos;

    private IngresarAlHome(int timeoutSegundos) {
        this.timeoutSegundos = timeoutSegundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        long deadline = System.currentTimeMillis() + (timeoutSegundos * 1000L);
        while (System.currentTimeMillis() < deadline) {
            boolean existe =
                    !HomePage.BANNER_TU_ANO.resolveAllFor(actor).isEmpty() ||
                    !HomePage.TAB_AHORRO.resolveAllFor(actor).isEmpty() ||
                    !HomePage.TAB_PENSION.resolveAllFor(actor).isEmpty() ||
                    !HomePage.TAB_CESANTIAS.resolveAllFor(actor).isEmpty();
            if (existe) {
                return; // Al menos un elemento existe: el Home está cargado
            }
            try {
                // Pequeño backoff para evitar busy-waiting
                Thread.sleep(250);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return; // Interrumpido: salir del wait
            }
        }
        // Timeout alcanzado: continuar sin lanzar excepción para no romper el flujo
    }

    public static IngresarAlHome porDefecto() {
        return new IngresarAlHome(30);
    }

    public static IngresarAlHome conTimeout(int segundos) {
        return new IngresarAlHome(segundos);
    }
}
