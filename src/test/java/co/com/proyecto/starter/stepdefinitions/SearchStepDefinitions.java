package co.com.proyecto.starter.stepdefinitions;

import co.com.proyecto.starter.tasks.navigation.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import co.com.proyecto.starter.userinterfaces.search.LookForInformation;

import java.awt.*;
import java.io.IOException;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theSearchHomePage());
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) throws AWTException, IOException {
        actor.attemptsTo(
                Ensure.that(TheWebPage.title()).containsIgnoringCase(term)
        );
    }

}
