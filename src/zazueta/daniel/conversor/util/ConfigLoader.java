package zazueta.daniel.conversor.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("src/resources/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
