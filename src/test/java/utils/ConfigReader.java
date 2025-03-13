package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
