package co.com.proyecto.starter.interactions.servicios;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.annotations.Step;

import java.util.Map;

public class GetWithHeader extends RestInteraction {

    private Map<String, Object> headers;
    private String resource;

    public GetWithHeader(String resource, Map<String, Object> headers) {
        this.headers = headers;
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest
                .given()
                .headers(headers)
                .when()
                .get(resource)  // Método GET
                .then()
                .log().all();
    }
}
