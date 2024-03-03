package uy.com.ces.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesConfiguration {

    private PropertiesConfiguration() {
    }

    private static Properties prop = loadProperties();

    public static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    
        return properties;
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
