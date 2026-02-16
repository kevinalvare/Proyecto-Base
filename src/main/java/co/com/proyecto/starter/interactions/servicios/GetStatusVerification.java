package co.com.proyecto.starter.interactions.servicios;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class GetStatusVerification extends RestInteraction {
    private String resource;

    public GetStatusVerification(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .when()
                .get(as(actor).resolve(resource))
                .then().statusCode(200);
    }
}
