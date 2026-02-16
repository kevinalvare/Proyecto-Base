package co.com.proyecto.starter.questions;


import co.com.proyecto.starter.models.api.ResponseCodigoError;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarResponseCodigoErrorRestringirAcceso implements Question<Boolean> {
    private final String codigoEsperado;

    public ValidarResponseCodigoErrorRestringirAcceso(String codigoEsperado) {
        this.codigoEsperado = codigoEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseCodigoError response = actor.recall("ResponseCodigoError");
        return response != null && response.getCodigo().equals(codigoEsperado);
    }

    public static ValidarResponseCodigoErrorRestringirAcceso conCodigo(String codigoEsperado) {
        return new ValidarResponseCodigoErrorRestringirAcceso(codigoEsperado
        );
    }

}
