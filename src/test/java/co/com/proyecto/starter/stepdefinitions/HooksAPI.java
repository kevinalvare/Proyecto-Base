package co.com.proyecto.starter.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

import static co.com.proyecto.starter.utils.PropertiesManager.getValue;


public class HooksAPI {

    public static Actor actor;
    public static EnvironmentVariables environmentVariables;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Usuario");
        environmentVariables = new SystemEnvironmentVariables();
        String apiUrl = environmentVariables.optionalProperty("api.url").orElse(getValue("endpoint"));
        actor.whoCan(CallAnApi.at(apiUrl));
    }

}
