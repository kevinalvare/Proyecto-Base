package co.com.proyecto.starter.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;

public class LoginPage extends PageObject {

    public static final Target INGRESAR = Target
            .the("button Login boton")
            .located(id("Login__button"));
    public static final Target USUARIO = Target
            .the("Input Usuario")
            .located(id("LogonName"));
    public static final Target PASSWORD = Target
            .the("Input Contraseña")
            .located(id("password"));
    public static final Target BTNCONTINUAR = Target
            .the("Boton Continuar")
            .located(id("continue"));

}
