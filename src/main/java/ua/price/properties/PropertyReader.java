package ua.price.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String name) {
        try {
            Properties props = new Properties();
            props.load(ClassLoader.class.getResourceAsStream("/test_properties.properties"));

            String property = props.getProperty(name);
            if (property == null) {
                throw new IllegalArgumentException("Could not read property with key " + name);
            }
            return property;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
