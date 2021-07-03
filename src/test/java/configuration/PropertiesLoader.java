package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {


    public Properties getPropertiesFromFile(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file " + fileName + " not found!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot load properties due to IOException");
        }
        return properties;
    }
}
