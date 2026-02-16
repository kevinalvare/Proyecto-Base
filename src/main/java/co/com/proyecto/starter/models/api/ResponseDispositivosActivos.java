package co.com.proyecto.starter.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseDispositivosActivos {
    private String idDispositivo;
    private String nombrePersonalizado;
    private String sistemaOperativo;
    private String modelo;

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public String getNombrePersonalizado() {
        return nombrePersonalizado;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getModelo() {
        return modelo;
    }
}
