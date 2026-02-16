package co.com.proyecto.starter.questions;


import co.com.proyecto.starter.models.api.ResponseMensajeGeneral;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarMensajeRespuesta implements Question<Boolean> {
    private final String mensajeEsperado;

    public ValidarMensajeRespuesta(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ResponseMensajeGeneral responseMensajeGeneral = actor.recall("ResponseMensajeGeneral");

        if (responseMensajeGeneral.getMensaje() == null || responseMensajeGeneral.getMensaje().isEmpty()) {
            return false;  // Evita NullPointerException y permite validar respuestas vacías
        }

        return responseMensajeGeneral.getMensaje().equals(mensajeEsperado);
    }

    public static ValidarMensajeRespuesta esIgualA(String mensajeEsperado) {
        return new ValidarMensajeRespuesta(mensajeEsperado);
    }

}
