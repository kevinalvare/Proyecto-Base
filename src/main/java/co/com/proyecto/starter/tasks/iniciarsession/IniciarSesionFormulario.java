package co.com.proyecto.starter.tasks.iniciarsession;


import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.proyecto.starter.userinterfaces.search.SearchForm.USUARIO;
import static co.com.proyecto.starter.userinterfaces.search.SearchForm.CONTRASENA;


public class IniciarSesionFormulario {
    public static Performable about(String usuario, String contraseña) {
        return Task.where("{0} searches for '" + "searchTerm" + "'",
                Enter.theValue(usuario)
                        .into(USUARIO)
                        .thenHit(Keys.ENTER),
                Enter.theValue(contraseña)
                        .into(CONTRASENA)
                        .thenHit(Keys.ENTER)
        );
    }
}
