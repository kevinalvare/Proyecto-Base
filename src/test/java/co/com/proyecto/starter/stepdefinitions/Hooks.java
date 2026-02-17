package co.com.proyecto.starter.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.openqa.selenium.WebDriver;


public class Hooks {

    public static Actor actor;

    @Managed(driver = "chrome")
    public static WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Usuario");  // Obtiene el actor directamente de Serenity
        actor.can(BrowseTheWeb.with(driver));  // Asigna WebDriver al actor
    }

}

