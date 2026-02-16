package co.com.proyecto.starter.utils;



import co.com.proyecto.starter.models.AfiliadoRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConstantsRequest {
    private ConstantsRequest() {
    }


    public static String requestCrearAfiliado(String primerNombre, String primerApellido, String tipoId, String id, String usuario, String clave) {
        String request = "{\n" +
                "  \"odata.type\": \"Microsoft.DirectoryServices.User\",\n" +
                "  \"objectType\": \"User\",\n" +
                "  \"displayName\": \"%s %s\",\n" +
                "  \"accountEnabled\": true,\n" +
                "  \"passwordPolicies\": \"DisablePasswordExpiration, DisableStrongPassword\",\n" +
                "  \"passwordProfile\" : {\n" +
                "  \"password\": \"%s\",\n" +
                "  \"forceChangePasswordNextLogin\": false,\n" +
                "  \"enforceChangePasswordPolicy\": false\n" +
                "  },\n" +
                "  \"signInNames\": [\n" +
                "    {\n" +
                "      \"type\": \"userName\",\n" +
                "      \"value\": \"%s\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"surname\": \"%s\",\n" +
                "  \"userType\": \"Member\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Expiracion\": \"3/27/2026\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_TipoId\": \"%s\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Id\": \"%s\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Bloqueo\": false,\n" +
                "  \"extension_52539248018846f982444ea136045b0e_AutoMigration\": false\n" +
                "}";
        request = String.format(request, primerNombre, primerApellido, clave, usuario, primerApellido, tipoId, id);
        return request;
    }

    public static String requestCrearAfiliadoRestringirInicioSesion(AfiliadoRequest afiliadoRequest) {
        String fecha = afiliadoRequest.isPasswordExpirationDate() ? obtenerFechaMenorAlaActual() : "3/27/2026";
        String request = "{\n" +
                "  \"odata.type\": \"Microsoft.DirectoryServices.User\",\n" +
                "  \"objectType\": \"User\",\n" +
                "  \"displayName\": \"%s %s\",\n" +
                "  \"accountEnabled\": %s,\n" +
                "  \"passwordPolicies\": \"DisablePasswordExpiration, DisableStrongPassword\",\n" +
                "  \"passwordProfile\" : {\n" +
                "  \"password\": \"%s\",\n" +
                "  \"forceChangePasswordNextLogin\": false,\n" +
                "  \"enforceChangePasswordPolicy\": false\n" +
                "  },\n" +
                "  \"signInNames\": [\n" +
                "    {\n" +
                "      \"type\": \"userName\",\n" +
                "      \"value\": \"%s\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"surname\": \"%s\",\n" +
                "  \"userType\": \"Member\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Expiracion\": \"%s\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_TipoId\": \"%s\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Id\": \"%s\",\n" +
                "  \"extension_52539248018846f982444ea136045b0e_Bloqueo\": %s,\n" +
                "  \"extension_52539248018846f982444ea136045b0e_AutoMigration\": false\n" +
                "}";
        request = String.format(request, afiliadoRequest.getPrimerNombre(), afiliadoRequest.getPrimerApellido(), afiliadoRequest.isAccountEnabled(), afiliadoRequest.getClave(), afiliadoRequest.getUsuario(), afiliadoRequest.getPrimerApellido(), fecha, afiliadoRequest.getTipoId(), afiliadoRequest.getId(), afiliadoRequest.isPasswordBlocked());
        return request;
    }

    public static String obtenerFechaMenorAlaActual() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMenosUnAnio = fechaActual.minusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return fechaMenosUnAnio.format(formatter);
    }

}
