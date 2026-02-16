package co.com.proyecto.starter.models;

public class AfiliadoRequest {

    private String primerNombre;
    private String primerApellido;
    private String tipoId;
    private String id;
    private String usuario;
    private String clave;
    private boolean isAccountEnabled;
    private boolean isPasswordBlocked;
    private boolean passwordExpirationDate;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isAccountEnabled() {
        return isAccountEnabled;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        isAccountEnabled = accountEnabled;
    }

    public boolean isPasswordBlocked() {
        return isPasswordBlocked;
    }

    public void setPasswordBlocked(boolean passwordBlocked) {
        isPasswordBlocked = passwordBlocked;
    }

    public boolean isPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    public void setPasswordExpirationDate(boolean passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }
}
