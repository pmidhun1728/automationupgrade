package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;
static{

    String environment = System.getProperty("environment", System.getenv("ENVIRONMENT"));

    if(environment==null || environment.isEmpty()){
        environment="qa";
    }

    String fileName = "src/test/resources/configuration.properties-" + environment+".properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
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
