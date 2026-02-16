package co.com.proyecto.starter.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class HttpResponseCode implements Question<Integer> {

    public static HttpResponseCode status() {
        return new HttpResponseCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getStatusCode();
    }

}
