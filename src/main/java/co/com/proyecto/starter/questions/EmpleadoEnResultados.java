package co.com.proyecto.starter.questions;

import co.com.proyecto.starter.userinterfaces.search.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class EmpleadoEnResultados implements Question<Boolean> {

    private final String nombre;
    private final String apellido;

    public EmpleadoEnResultados(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String nombreEnFila = Text.of(Home.EMPLOYEE_ROW_FIRST).answeredBy(actor);
        String apellidoEnFila = Text.of(Home.EMPLOYEE_LAST_NAME_FIRST).answeredBy(actor);

        return nombreEnFila != null && apellidoEnFila != null
                && nombreEnFila.contains(nombre)
                && apellidoEnFila.contains(apellido);
    }

    public static EmpleadoEnResultados conNombreYApellido(String nombre, String apellido) {
        return new EmpleadoEnResultados(nombre, apellido);
    }
}

