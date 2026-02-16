package co.com.proyecto.starter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseIntercambiarCodigoB2c {
    private String accessToken;
    private String refreshToken;
    private int tiempoExpiracion;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public int getTiempoExpiracion() {
        return tiempoExpiracion;
    }
}
