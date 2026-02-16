package co.com.proyecto.starter.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseMensajeGeneral {
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }
}
