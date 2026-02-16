package co.com.proyecto.starter.questions;


import co.com.proyecto.starter.models.api.ResponseIntercambiarToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarResponseIntercambiarToken implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseIntercambiarToken response = actor.recall("ResponseIntercambiarToken");

        return response != null &&
                response.getAccessToken() != null && !response.getAccessToken().trim().isEmpty() &&
                response.getToken() != null && !response.getToken().trim().isEmpty();

    }

    public static ValidarResponseIntercambiarToken esValido() {
        return new ValidarResponseIntercambiarToken();
    }
}
