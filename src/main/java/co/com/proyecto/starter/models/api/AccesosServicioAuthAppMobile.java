package co.com.proyecto.starter.models.api;

public class AccesosServicioAuthAppMobile {
    private String resourse;
    private String x_api_key;

    public AccesosServicioAuthAppMobile(String resourse, String contentType) {
        this.resourse = resourse;
        this.x_api_key = contentType;
    }

    public String getResourse() {
        return resourse;
    }

    public String getX_api_key() {
        return x_api_key;
    }
}
