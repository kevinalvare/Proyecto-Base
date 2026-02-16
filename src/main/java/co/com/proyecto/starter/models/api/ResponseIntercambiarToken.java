package co.com.proyecto.starter.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseIntercambiarToken {
    private String accessToken;
    private String token;

    public String getAccessToken() {
        return accessToken;
    }

    public String getToken() {
        return token;
    }
}
