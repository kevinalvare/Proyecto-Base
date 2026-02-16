package co.com.proyecto.starter.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseEnrolarDispositivo {
    private String nombreAfiliado;
    private String token;

    public String getNombreAfiliado() {
        return nombreAfiliado;
    }

    public String getToken() {
        return token;
    }
}
