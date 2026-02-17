package co.com.proyecto.starter.utils;

import co.com.proyecto.starter.exceptions.TestFailure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private PropertiesManager() { throw new IllegalStateException("Utility class"); }

    private static final String RUTA_PROPERTIES = "properties/environment.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = PropertiesManager.class.getClassLoader().getResourceAsStream(RUTA_PROPERTIES)) {
            if (stream == null) {
                throw new TestFailure("No se encontro el archivo properties/environment.properties en el classpath");
            }
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            throw new TestFailure("Error al leer el archivo properties/environment.properties");
        }
    }

    public static String getValue(String key)
    {
        Properties properties = loadProperties();
        return properties.getProperty(key);
    }
}
