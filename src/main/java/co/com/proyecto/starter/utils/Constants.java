package co.com.proyecto.starter.utils;



import co.com.proyecto.starter.models.api.ResponseCodigoError;

import java.util.Map;
import java.util.function.Supplier;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static class Messages {

        private Messages() {
        }

        public static final String MSG_FIN_PRUEBA = "Finaliza test";
        public static final String MSG_INICIA_PRUEBA = "Inicia test";
        public static final String MSG_EXEC_ACCION = "Validando resultado de la accion: {}";
        public static final String MSG_EXEC_ACCION_PAGINA = "Accediendo a la pagina: {}";
        public static final String MSG_FIN_ACCION_PAGINA = "Página cargada con exito";
        public static final String CLAVE_ESTANDAR = "444444";
    }

    public static class CuentaDeshabilitada {

        private CuentaDeshabilitada() {
        }

        public static final String CODIGO = "BN91";
        public static final String CAUSAL = "Cuenta deshabilitada";
        public static final String DESCRIPCION = "La cuenta del usuario se encuentra deshabilitada en b2c";
    }

    public static class PasswordBloqueado {

        private PasswordBloqueado() {
        }

        public static final String CODIGO = "BN92";
        public static final String CAUSAL = "Password bloqueado";
        public static final String DESCRIPCION = "El usuario tiene el password bloqueado en b2c";
    }

    public static class CambioPasswordReciente {

        private CambioPasswordReciente() {
        }

        public static final String CODIGO = "BN94";
        public static final String CAUSAL = "Cambio de password reciente";
        public static final String DESCRIPCION = "El usuario cambio el password recientemente en b2c";
    }


    public static class PasswordExpirado {

        private PasswordExpirado() {
        }

        public static final String CODIGO = "BN93";
        public static final String CAUSAL = "Password expirado";
        public static final String DESCRIPCION = "El usuario tiene el password expirado en b2c";
        public static final String RESPONSE_CODIGO_ERROR_ENROLAR_DISPOSITIVO = "ResponseEnrolarDispositivoEnrolarDispositivoRegistrado";
        public static final String RESPONSE_CODIGO_ERROR_REGISTRAR_DISPOSITIVO = "ResponseRegistrarDispositivoExistente";
    }

    public static ResponseCodigoError respuestaEsperada(boolean isAccountEnabled, boolean isPasswordBlocked, boolean isPasswordExpirationDate) {
        Map<String, Supplier<ResponseCodigoError>> estrategias = Map.of(
                "false", () -> responseCodigoError(CuentaDeshabilitada.CODIGO, CuentaDeshabilitada.CAUSAL, CuentaDeshabilitada.DESCRIPCION),
                "true-true", () -> responseCodigoError(PasswordBloqueado.CODIGO, PasswordBloqueado.CAUSAL, PasswordBloqueado.DESCRIPCION),
                "true-false-true", () -> responseCodigoError(PasswordExpirado.CODIGO, PasswordExpirado.CAUSAL, PasswordExpirado.DESCRIPCION)
        );

        return estrategias.getOrDefault(getClave(isAccountEnabled, isPasswordBlocked, isPasswordExpirationDate), () -> null).get();
    }

    public static ResponseCodigoError respuestaEsperadaCambioContrasena() {
        return responseCodigoError(CambioPasswordReciente.CODIGO, CambioPasswordReciente.CAUSAL, CambioPasswordReciente.DESCRIPCION);
    }

    private static String getClave(boolean isAccountEnabled, boolean isPasswordBlocked, boolean isPasswordExpirationDate) {
        if (!isAccountEnabled) {
            return "false";
        }
        if (isPasswordBlocked) {
            return "true-true";
        }
        return isPasswordExpirationDate ? "true-false-true" : "true-false-false";
    }

    public static ResponseCodigoError responseCodigoError(String codigo, String causal, String descripcion) {
        ResponseCodigoError responseCodigoError = new ResponseCodigoError();
        responseCodigoError.setCodigo(codigo);
        responseCodigoError.setCausal(causal);
        responseCodigoError.setDescripcion(descripcion);
        return responseCodigoError;
    }


}
