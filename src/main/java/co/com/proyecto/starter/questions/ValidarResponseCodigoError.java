package co.com.proyecto.starter.questions;


import co.com.proyecto.starter.models.api.ResponseCodigoError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarResponseCodigoError implements Question<Boolean> {
    private final String codigoEsperado;
    private final String responseCodigoError;

    public ValidarResponseCodigoError(String codigoEsperado, String responseCodigoError) {
        this.codigoEsperado = codigoEsperado;
        this.responseCodigoError = responseCodigoError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseCodigoError response = actor.recall(responseCodigoError);
        return response != null && response.getCodigo().equals(codigoEsperado);
    }

    public static ValidarResponseCodigoError conCodigo(String codigoEsperado, String response) {
        return new ValidarResponseCodigoError(codigoEsperado, response
        );
    }

}
