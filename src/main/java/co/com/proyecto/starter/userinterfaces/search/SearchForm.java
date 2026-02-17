package co.com.proyecto.starter.userinterfaces.search;

import net.serenitybdd.screenplay.targets.Target;

public class SearchForm {
    public static Target USUARIO = Target.the("search field").locatedBy("//*[@placeholder='Username']");
    public static Target CONTRASENA = Target.the("search field").locatedBy("//*[@placeholder='Password']");

}
