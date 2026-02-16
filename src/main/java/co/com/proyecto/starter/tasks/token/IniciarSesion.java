package co.com.proyecto.starter.tasks.token;

import co.com.proyecto.starter.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarSesion implements Task {

    private final String usuario;
    private final String contrasena;

    public IniciarSesion(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Si el botón INGRESAR es visible, hacer clic; si no, continuar sin error
                Check.whether(isVisible().matches(LoginPage.INGRESAR.resolveFor(actor)))
                        .andIfSo(Click.on(LoginPage.INGRESAR)),

                // Esperar hasta que el campo de usuario sea visible
                WaitUntil.the(LoginPage.USUARIO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(usuario).into(LoginPage.USUARIO),

                // Esperar hasta que el campo de contraseña sea visible antes de escribir
                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(contrasena).into(LoginPage.PASSWORD),

                // Esperar hasta que el botón esté habilitado antes de hacer clic
                WaitUntil.the(LoginPage.BTNCONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(LoginPage.BTNCONTINUAR)
        );
    }

    public static IniciarSesion conCredenciales(String usuario, String contrasena) {
        return new IniciarSesion(usuario, contrasena);
    }

}
