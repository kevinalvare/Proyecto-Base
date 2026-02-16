package co.com.proyecto.starter.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseCodigoError {
    private String codigo;
    private String causal;
    private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public String getCausal() {
        return causal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
